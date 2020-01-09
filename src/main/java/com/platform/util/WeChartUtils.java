package com.platform.util;

import com.alibaba.fastjson.JSONObject;
import com.platform.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 微信工具类
 */
public class WeChartUtils {
    @Autowired
    RedisUtil redisUtil;
    //↓微信公众号第三方唯一凭证
    public static final String APPID = "wxec5e79b6b9083";
    //↓第三方用户唯一密匙
    public static final String SECRET = "3fe423115608815dc79f4";
    //↓获取access_token时调用下方
    public static final String GRANT_TYPE = "client_credential";
    //↓type  jsapi
    public static final String JSAPI_TYPE = "jsapi";
    //↓获取用户基本信息 unionId机制  https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140839
    private static final String USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";

    /**
     * 获取公众号JS-API 权限签名算法 添加redis
     *
     * @param ACCESS_TOKEN 公众号token
     * @return
     */
    public static Map<String, Object> queryWxChartsJsApiTicket(String ACCESS_TOKEN) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
        Map getParam = new HashMap();
        getParam.put("access_token", ACCESS_TOKEN);
        getParam.put("type", JSAPI_TYPE);
        String httpGet = HttpUtil.URLGet(url, getParam, HttpUtil.URL_PARAM_DECODECHARSET_UTF8);
        responseMap = JSONObject.parseObject(httpGet);
        System.out.println(httpGet);
        return responseMap;
    }

    /**
     * 获取网页授权ACCESS_TOKEN
     *
     * @param CODE
     * @return
     */
    public static Map<String, Object> queryWxOAthAccessToken(String CODE) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map getParam = new HashMap();
        getParam.put("appid", APPID);
        getParam.put("secret", SECRET);
        getParam.put("code", CODE);
        getParam.put("grant_type", "authorization_code");
        String httpGet = HttpUtil.URLGet(url, getParam, HttpUtil.URL_PARAM_DECODECHARSET_UTF8);
        responseMap = JSONObject.parseObject(httpGet);
        return responseMap;
    }

    /**
     * 获取微信基本token
     *
     * @return
     */
    public static Map<String, Object> queryWxBaseToken() {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        String url = "https://api.weixin.qq.com/cgi-bin/token";
        Map getParam = new HashMap();
        getParam.put("grant_type", "client_credential");
        getParam.put("appid", APPID);
        getParam.put("secret", SECRET);
        String httpGet = HttpUtil.URLGet(url, getParam, HttpUtil.URL_PARAM_DECODECHARSET_UTF8);
        responseMap = JSONObject.parseObject(httpGet);
        return responseMap;
    }

    /**
     * 查询微信用户信息
     *
     * @return
     */
    public static Map<String, Object> queryWxUserInfo(String token, String openid) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        try {
            String url = "https://api.weixin.qq.com/sns/userinfo";
            Map param = new HashMap();
            param.put("access_token", token);
            param.put("openid", openid);
            param.put("lang", "zh_CN");
            String httpGet = HttpUtil.URLGet(url, param, HttpUtil.URL_PARAM_DECODECHARSET_UTF8);
            httpGet = new String(httpGet.getBytes("gbk"), "utf-8");
            responseMap = JSONObject.parseObject(httpGet);
        } catch (Exception e) {
            responseMap = null;
        }
        return responseMap;
    }

    /**
     * 获得随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomChar(int length) {
        char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(chr[random.nextInt(36)]);
        }
        return buffer.toString();
    }

    /**
     * sha1加密
     *
     * @param str
     * @return
     */
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    /**
     * 獲取微信用戶UnionID
     *
     * @param code
     * @return
     */
    public static String queryWxUnionId(String code) {

        String unionId = "";
        try {
            String authToken = "";
            Map<String, Object> queryAuthToken = WeChartUtils.queryWxOAthAccessToken(code.trim());
            if (queryAuthToken.containsKey("access_token") == true) {
                authToken = queryAuthToken.get("access_token").toString().trim();
                unionId = queryAuthToken.get("openid").toString().trim();
                int expirse = Integer.parseInt(queryAuthToken.get("expires_in").toString().trim());
//                redisUtil.set("WX_AUTH_TOKEN", authToken);
//                redisUtil.expire("WX_AUTH_TOKEN", expirse);
            }

        } catch (Exception e) {
            unionId = "";
        }
        return unionId;
    }
}
//    public static String convert(SmsTemplateDO temp, String code) {
//
//        String template = temp.getContent();
//        while (template.contains("${")) {
//            Matcher matcher = PARAM_PATTERN.matcher(template);
//            if (matcher.find()) {
//                String ele = "code";
//                template = template.replaceFirst("\\$\\{" + ele + "\\}", code);
//            }
//        }
//        log.info(template);
//        return template;
//    }