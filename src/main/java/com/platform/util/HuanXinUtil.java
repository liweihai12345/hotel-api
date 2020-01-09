package com.platform.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 环信IM
 */
public class HuanXinUtil {
    private static final String ORG_NAME = "11151902047496";
    private static final String APP_NAME = "dongdong";
    //↓注册地址
    private static final String HUANXIAN_URL = "https://a1.easemob.com/" + ORG_NAME + "/" + APP_NAME;
    private static final String CLIENT_ID = "YXA6QaQ2cDQ2EmnlXUUoUudkw";
    private static final String CLIENT_SECRET = "YXA6YmcZE3hs8FnWzTpCdSV5MmX6I";
    private static final String GRANT_TYPE = "client_credentials";


    /**
     * 获取环信token
     *
     * @return
     */
    public static Map<String, Object> queryHuanXianToken() throws Exception {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        try {
            Map queryMap = new HashMap();
            queryMap.put("grant_type", GRANT_TYPE);
            queryMap.put("client_id", CLIENT_ID);
            queryMap.put("client_secret", CLIENT_SECRET);
            String parmaJson = JSONObject.toJSONString(queryMap);
            String result = sendPost(parmaJson, HUANXIAN_URL + "/token", "");
            responseMap = JSONObject.parseObject(result.trim());
        } catch (Exception e) {
            responseMap = null;
        }
        return responseMap;
    }

    /**
     * 注册环信用户账号
     *
     * @return
     */
    public static Map<String, Object> registerUser(String userPhone, String token, String nickName) {
        Map<String, Object> responseMap = null;
        try {
            Map queryMap = new HashMap();
            queryMap.put("username", userPhone.trim());
            queryMap.put("password", "DongDong" + userPhone);
            queryMap.put("nickname", nickName.trim());
            String param = JSONObject.toJSONString(queryMap);
            String result = sendPost(param, HUANXIAN_URL + "/users", token);
            responseMap = JSONObject.parseObject(result);
        } catch (Exception e) {
            responseMap = null;
        }
        return responseMap;
    }

    /**
     * 发送post请求
     *
     * @param params
     * @param requestUrl
     * @param token
     * @return
     * @throws IOException
     */
    public static String sendPost(String params, String requestUrl, String token) throws IOException {
        byte[] requestBytes = params.getBytes("utf-8"); // 将参数转为二进制流
        HttpClient httpClient = new HttpClient();// 客户端实例化
        PostMethod postMethod = new PostMethod(requestUrl);
        if (!token.trim().equals("")) {
            //设置请求头Authorization
            postMethod.setRequestHeader("Authorization", "Bearer " + token);
        }
        // 设置请求头  Content-Type
        postMethod.setRequestHeader("Content-Type", "application/json");
        InputStream inputStream = new ByteArrayInputStream(requestBytes, 0,
                requestBytes.length);
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                requestBytes.length, "application/json; charset=utf-8"); // 请求体
        postMethod.setRequestEntity(requestEntity);
        httpClient.executeMethod(postMethod);// 执行请求
        InputStream soapResponseStream = postMethod.getResponseBodyAsStream();// 获取返回的流
        byte[] datas = null;
        try {
            datas = StringUtils.readInputStream(soapResponseStream);// 从输入流中读取数据
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = new String(datas, "UTF-8");// 将二进制流转为String
        return result;
    }

    /**
     * 查询IM用户信息
     *
     * @param phone
     * @return
     */
    public static String checkUserExists(String phone, String token) {
        String result = "";
        try {
            HttpClient client = new HttpClient();
            String url = HUANXIAN_URL + "/users/" + phone.trim();
            GetMethod get = new GetMethod(url);
            get.setRequestHeader("Authorization", "Bearer " + token);
            int status = client.executeMethod(get);
            result = get.getResponseBodyAsString().trim();
        } catch (Exception e) {
            result = "";
            System.err.println(e.getMessage());
        }
        return result;
    }

//    /**
//     * 修改IM用户昵称
//     *
//     * @param phone
//     * @param token
//     * @param param 参数
//     * @return
//     */
//    public static String updateUserNickName(String phone, String token, String param) {
//        String result = "";
//        try {
//            HttpClient client = new HttpClient();
//            String url = HUANXIAN_URL + "/users/" + phone.trim();
//            PutMethod put = new PutMethod(url);
//            put.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
//            put.setRequestHeader("Authorization", "Bearer " + token);
//            put.setRequestBody(param);
//            int statu = client.executeMethod(put);
//            result = put.getResponseBodyAsString().trim();
//        } catch (Exception e) {
//            result = "";
//            System.err.println(e.getMessage());
//        }
//        return result;
//    }


    /**
     * IM发送系统消息
     *
     * @return
     */
    public static Map<String, Object> sendSystemMes(String msg, String[] users, String token) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        try {
            Map queryMap = new HashMap();
            queryMap.put("target_type", "users");
            queryMap.put("target", users);
            Map p = new HashMap();
            p.put("type", "txt");
            p.put("msg", msg);
            queryMap.put("msg", JSONObject.toJSON(p));
            queryMap.put("from", "官方客服");
            String param = JSONObject.toJSONString(queryMap);
            String result = sendPost(param, HUANXIAN_URL + "/messages", token);
            responseMap = JSONObject.parseObject(result);
        } catch (Exception e) {
            responseMap = null;
        }
        return responseMap;
    }


}
