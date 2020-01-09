package com.platform.payinterface.wx;

import com.platform.util.HttpRequestUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.*;
@Component
public class WXUtil {
    static Logger log = LoggerFactory.getLogger(WXUtil.class);
    private static String NOTIFY_URL_VALUE;
    @Value("${notify.url.wx}")
    public void setNotifyUrlValue(String notifyUrlValue) {
        NOTIFY_URL_VALUE = notifyUrlValue;
    }

    /**
     * 根据订单编号和金额
     * 创建xml格式的数据
     *
     * @param out_trad_no 充值帐单编号
     * @param amount      充值金额
     * @return xml
     */
    public static String buildWxRequestArgs(String out_trad_no, String amount) {
        try {
            List<NameValuePair> param = buildNameValuePairParam(out_trad_no, amount);
            // 拿到请求微信的签名
            String sign = WXUtil.getWxRequestSign(param);
            //把签名存入NameValuePair对象中
            param.add(new BasicNameValuePair(WXConstants.SIGN, sign));
            // 转化为xml
            String xmlstring = XMLUtil.toXml(param);

            return xmlstring;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 构建NameValuePair 数据对象
     */
    private static List<NameValuePair> buildNameValuePairParam(String out_trad_no, String amount) {
        List<NameValuePair> packageParams = new LinkedList<NameValuePair>();
        String nonceStr = getNonceStr();// 获取随机数
        packageParams.add(new BasicNameValuePair(WXConstants.APP_ID, WXConstants.APP_ID_VALUE));
        packageParams.add(new BasicNameValuePair(WXConstants.BODY, WXConstants.APP_BODY));
        packageParams.add(new BasicNameValuePair(WXConstants.MCH_ID, WXConstants.MCH_ID_VALUE));
        packageParams.add(new BasicNameValuePair(WXConstants.NONCE_STR, nonceStr));
        packageParams.add(new BasicNameValuePair(WXConstants.NOTIFY_URL, NOTIFY_URL_VALUE));
        packageParams.add(new BasicNameValuePair(WXConstants.OUT_TRADE_NO, out_trad_no));
        packageParams.add(new BasicNameValuePair(WXConstants.SPBILL_CREATE_IP, WXConstants.SPBILL_CREATE_IP_VALUE));
        packageParams.add(new BasicNameValuePair(WXConstants.TOTAL_FEE, amount));
        packageParams.add(new BasicNameValuePair(WXConstants.TRADE_TYPE, WXConstants.TRADE_TYPE_VALUE));

        return packageParams;
    }

    /**
     * 系统服务访问微信服务
     *
     * @param url
     * @param entity
     * @return
     */
    public static String httpPost(String url, String entity) {
        if (url == null || url.length() == 0) {
            return null;
        }

        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new StringEntity(entity, "UTF-8"));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse resp = httpClient.execute(httpPost);
            // 链接返回状态码为200成功否则失败
            if (resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {

                return null;
            }
            HttpEntity entity1 = resp.getEntity();
            long responseLength = resp.getHeaders("Content-Length").length;//响应长度
            String responseContent = null;    //响应内容
            String content = EntityUtils.toString(entity1, "UTF-8");
            log.debug("微信请求地址: " + httpPost.getURI());
            log.debug("微信响应状态: " + resp.getStatusLine());
            log.debug("微信响应长度: " + responseLength);
            log.debug("微信响应内容: " + responseContent);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * NameValuePair 已排好顺序
     * 生成后台请求微信需要的签名
     *
     * @param params LinkedList 参数
     * @return
     */
    public static String getWxRequestSign(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.size(); i++) {
            sb.append(params.get(i).getName());
            sb.append('=');
            sb.append(params.get(i).getValue());
            sb.append('&');
        }
        sb.append("key=");
        sb.append(WXConstants.API_KEY_VALUE);
        log.debug("微信后台请求微信待签名的参数：" + sb.toString());
        String packageSign = "";
        try {
            packageSign = MD5.getMessageDigest(sb.toString().getBytes("UTF-8")).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            log.debug("签名UTF-8错误");
        }
        return packageSign;
    }

    /**
     * 暂时未用到
     * 解析微信返回的数据重新配置带签名参数
     *
     * @param newResultMap
     * @return
     */
    public static List<NameValuePair> getAppResponseNameValue(Map<String, String> newResultMap) {
        List<NameValuePair> param = new LinkedList<NameValuePair>();
        long timestamp = System.currentTimeMillis() / 1000;
        param.add(new BasicNameValuePair(WXConstants.APP_ID, newResultMap.get(WXConstants.APP_ID)));
        param.add(new BasicNameValuePair(WXConstants.PARTNERID, newResultMap.get(WXConstants.MCH_ID)));
        param.add(new BasicNameValuePair(WXConstants.PREPAYID, newResultMap.get(WXConstants.PREPAY_ID)));
        param.add(new BasicNameValuePair(WXConstants.PACKAGE, WXConstants.PACKAGE_VALUE));
        param.add(new BasicNameValuePair(WXConstants.NONCESTR, newResultMap.get(WXConstants.NONCE_STR)));
        param.add(new BasicNameValuePair(WXConstants.TIME_STAMP, String.valueOf(timestamp)));
        param.add(new BasicNameValuePair(WXConstants.SIGN, getWxRequestSign(param)));

        return param;
    }

    /**
     * 解析微信返回的数据重新配置带签名参数
     *
     * @param newResultMap
     * @return map 包含签名的map
     */
    public static Map<String, String> getAppResponseMap(Map<String, String> newResultMap) {
        Map<String, String> newMap = new HashMap<String, String>();
        String timestamp = String.valueOf(genTimeStamp());
        newMap.put(WXConstants.APP_ID, newResultMap.get(WXConstants.APP_ID));
        newMap.put(WXConstants.PARTNERID, newResultMap.get(WXConstants.MCH_ID));
        newMap.put(WXConstants.PREPAYID, newResultMap.get(WXConstants.PREPAY_ID));
        newMap.put(WXConstants.PACKAGE, WXConstants.PACKAGE_VALUE);
        newMap.put(WXConstants.NONCESTR, newResultMap.get(WXConstants.NONCE_STR));
        newMap.put(WXConstants.TIME_STAMP, timestamp);
        newResultMap.put(WXConstants.SIGN, getSign(newMap));
        newResultMap.put(WXConstants.TIME_STAMP, timestamp);

        return newResultMap;
    }

    /**
     * 去除空值 去掉sign去掉key
     *
     * @param map
     * @return sign 签名
     */
    private static String getSign(Map<String, String> map) {
        SortedMap<String, String> signParams = new TreeMap<String, String>();
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            signParams.put(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        String sign = createAppSign("UTF-8", signParams);
        return sign;
    }

    /**
     * 创建APP请求微信的sign
     *
     * @param characterEncoding
     * @param parameters
     * @return
     */
    private static String createAppSign(String characterEncoding, SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + WXConstants.API_KEY_VALUE);//最后加密时添加商户密钥，由于key值放在最后，所以不用添加到SortMap里面去，单独处理，编码方式采用UTF-8
        log.debug("返回给APP请求微信的待签名字符串：" + sb.toString());
        String sign = null;
        try {
            sign = MD5.getMessageDigest(sb.toString().getBytes(characterEncoding)).toUpperCase();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        return sign;
    }

    /**
     * 校验签名是否真实
     *
     * @return
     */
    public static boolean checkSign(Map<String, String> map) {
/*		        Map<String, String> map = null;
		        try {
		            map = XMLUtil.decodeXml(xmlString);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }*/
        log.debug("进入微信验签功能:" + map);
        String signFromAPIResponse = map.get("sign").toString();
        if (signFromAPIResponse == "" || signFromAPIResponse == null) {
            log.debug("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
            return false;
        }
        log.debug("服务器回包里面的签名是:" + signFromAPIResponse);
        //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        map.put("sign", "");
        //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        log.debug("微信待验签拼接去空去关键字:" + map);
        String newsign = getSign(map);
        log.debug("微信新签名:" + newsign);
        if (!newsign.equals(signFromAPIResponse)) {
            //签名验不过，表示这个API返回的数据有可能已经被篡改了
            log.debug("API返回的数据签名验证不通过，有可能被第三方篡改!!! signForAPIResponse生成的签名为" + newsign);
            return false;
        }
        log.debug("恭喜，API返回的数据签名验证通过!!!");

        return true;
    }

    /**
     * 获取随机字符串
     *
     * @return string
     */
    private static String getNonceStr() {
        Random random = new Random();
        return MD5.getMessageDigest(String.valueOf(random.nextInt(10000))
                .getBytes());
    }

    /**
     * 获取当前的时间戳
     *
     * @return long Time
     */
    private static long genTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 验证回调签名
     *
     * @return
     */
    public static boolean isTenpaySign(Map<String, String> map) {
        String characterEncoding = "utf-8";
        String charset = "utf-8";
        String signFromAPIResponse = map.get("sign");
        if (signFromAPIResponse == null || signFromAPIResponse.equals("")) {
            log.debug("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
            return false;
        }
        log.debug("服务器回包里面的签名是:" + signFromAPIResponse);
        //过滤空 设置 TreeMap
        SortedMap<String, String> packageParams = new TreeMap();

        for (String parameter : map.keySet()) {
            String parameterValue = map.get(parameter);
            String v = "";
            if (null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }

        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();

        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + WXConstants.API_KEY_VALUE);

        //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        //算出签名
        String resultSign = "";
        String tobesign = sb.toString();

        if (null == charset || "".equals(charset)) {
            resultSign = MD5Util.MD5Encode(tobesign, characterEncoding).toUpperCase();
        } else {
            try {
                resultSign = MD5Util.MD5Encode(tobesign, characterEncoding).toUpperCase();
            } catch (Exception e) {
                resultSign = MD5Util.MD5Encode(tobesign, characterEncoding).toUpperCase();
            }
        }

        String tenpaySign = ((String) packageParams.get("sign")).toUpperCase();
        return tenpaySign.equals(resultSign);
    }

    /**
     * APP微信登陆获取token
     *
     * @param code
     * @return
     */
    public static String getWxLoginToken(@RequestParam(value = "code") String code) {

        //通过code换取网页授权access_token
        StringBuilder sb = new StringBuilder();
        sb.append("appid=").append(WXConstants.APPID);
        sb.append("&secret=").append(WXConstants.APPSECRET);
        sb.append("&code=").append(code);
        sb.append("&grant_type=authorization_code");
        //发送请求
        String result = HttpRequestUtil.sendGet(WXConstants.ACCESS_TOKEN_BASE_URL, sb.toString());
        // JSONObject json = JSONObject.parseObject(jsonResult);
        return result;

    }

    /**
     * APP微信登陆获取用户基本
     *
     * @param accessToken
     * @param openid
     * @return
     */
    public static String getWxUserInfo(String accessToken, String openid) {
        StringBuilder access = new StringBuilder();
        access.append("access_token=").append(accessToken);
        access.append("&openid=").append(openid);
        access.append("&lang=zh_CN");
        String result = HttpRequestUtil.sendGet(WXConstants.INFO_BASE_URL, access.toString());
        log.info("----" + result);
        return result;
    }

    /**
     * APP微信登陆获取token
     *
     * @param code
     * @return
     */
    public static String getWxLoginTokenJS(@RequestParam(value = "code") String code) {

        //通过code换取网页授权access_token
        StringBuilder sb = new StringBuilder();
        sb.append("appid=").append(WXConstants.APPIDJS);
        sb.append("&secret=").append(WXConstants.SECRETJS);
        sb.append("&code=").append(code);
        sb.append("&grant_type=authorization_code");
        //发送请求
        String result = HttpRequestUtil.sendGet(WXConstants.ACCESS_TOKEN_BASE_URL, sb.toString());
        // JSONObject json = JSONObject.parseObject(jsonResult);
        log.info(result);
        return result;

    }
//    /**
//     * APP微信登陆获取用户基本
//     * @param accessToken
//     * @param openid
//     * @return
//     */
//    public static String getWxUserInfoJS(String accessToken,String openid) {
//        StringBuilder access = new StringBuilder();
//        access.append("access_token=").append(accessToken);
//        access.append("&openid=").append(openid);
//        access.append("&lang=zh_CN");
//        String result = HttpRequestUtil.sendGet(WXConstants.INFO_BASE_URL,access.toString());
//        return result;
//    }

}
