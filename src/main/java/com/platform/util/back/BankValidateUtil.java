package com.platform.util.back;

import com.alibaba.fastjson.JSONObject;
import com.platform.util.StringUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 验证银行卡
 */
public class BankValidateUtil {
    private static final String SECRET_ID = "AKIDhi8UdZSZg43iPdhnx3O8egca0hqN6xksRLBt";
    private static final String SECRET_KEY = "7q7p9O3q6Qlaw9bkb38Blr6oca2LUi688JHCKcbj";
    private static final String CONTENT_CHARSET = "UTF-8";
    private static final String HMAC_ALGORITHM = "HmacSHA1";
    private static final String URL = "http://service-quy53u1y-1255327000.ap-guangzhou.apigateway.myqcloud.com/release/nameIDCardAccountDetailVerify";
    private static final String HOST = "sservice-quy53u1y-1255327000.ap-guangzhou.apigateway.myqcloud.com";

    /**
     * 验证签名
     *
     * @return
     */
    public static String calculationTicket(String timeStr) throws Exception {
        String signStr = "date: " + timeStr + "\n" + "source: " + "source";
        String sig = null;
        Mac mac1 = Mac.getInstance(HMAC_ALGORITHM);
        byte[] hash;
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(CONTENT_CHARSET), mac1.getAlgorithm());
        mac1.init(secretKey);
        hash = mac1.doFinal(signStr.getBytes(CONTENT_CHARSET));
        sig = new String(Base64Util.encodeQ(hash));
        System.out.println("signValue--->" + sig);
        return sig;
    }

    /**
     * 验证微信验证码
     *
     * @param {cardNo idCardNo  realName  X51}
     * @return
     */
    public static Boolean validateBank(String realName, String idCardNo, String cardNo) {
        Map param = new HashMap();
        param.put("bankCard", cardNo);
        param.put("idNumber", idCardNo);
        param.put("name", realName.trim());
        param.put("serviceCode", "X51");
        String result = "";
        try {
            byte[] requestBytes = JSONObject.toJSONString(param).getBytes("utf-8");
            HttpClient httpClient = new HttpClient();
            PostMethod postMethod = new PostMethod(URL);

            /*获取时间*/
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String timeStr = sdf.format(cal.getTime());
            /*设置请求头*/
            String sign = calculationTicket(timeStr);
            String authen = "hmac id=\"" + SECRET_ID + "\", algorithm=\"hmac-sha1\", headers=\"date source\", signature=\"" + sign + "\"";
            postMethod.setRequestHeader("Host", HOST);
            postMethod.setRequestHeader("Accept", "text/html, */*; q=0.01");
            postMethod.setRequestHeader("Source", "source");
            postMethod.setRequestHeader("Date", timeStr);
            postMethod.setRequestHeader("Authorization", authen);
            postMethod.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            postMethod.setRequestHeader("Accept-Encoding", "gzip, deflate, sdch");
            postMethod.setRequestHeader("Content-Type", "application/json");

            InputStream inputStream = new ByteArrayInputStream(requestBytes, 0, requestBytes.length);
            RequestEntity requestEntity = new InputStreamRequestEntity(inputStream, requestBytes.length, "application/json;charset=utf-8");
            postMethod.setRequestEntity(requestEntity);
            httpClient.executeMethod(postMethod);
            InputStream soapResponseStream = postMethod.getResponseBodyAsStream();
            byte[] datas = null;
            datas = StringUtils.readInputStream(soapResponseStream);
            result = new String(datas, "UTF-8");
            return validateBankCard(result);
        } catch (Exception e) {
            result = "";
        }
        return false;
    }

    public static boolean validateBankCard(String result) {
        Map<String, Object> response = JSONObject.parseObject(result);
        Map<String, Object> dataMap = JSONObject.parseObject(response.get("data").toString());
        if (response.get("code").toString().trim().equals("200") && dataMap.get("key").equals("0000")) {
            return true;
        }
        return false;
    }


}
