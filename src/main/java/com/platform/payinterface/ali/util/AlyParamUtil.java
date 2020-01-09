package com.platform.payinterface.ali.util;

import com.platform.payinterface.ali.config.AlipayConfig;
import com.platform.payinterface.ali.sign.RSA;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Component
public class AlyParamUtil {

    private static String NOTIFY_URL_VALUE;

    @Value("${notify.url.ali}")
    public void setNotifyUrlValue(String notifyUrlValue) {
        NOTIFY_URL_VALUE = notifyUrlValue;
    }

    /**
     * 构造支付订单参数列表
     *
     * @param code   订单编号
     * @param amount 支付金额
     * @return map map对象
     */
    public static Map<String, String> initAppParamMap(String code, String amount) {
        Map<String, String> keyValues = new HashMap<String, String>();

        keyValues.put(AlipayConfig.APP_ID, AlipayConfig.APP_ID_VALUE);
        // 此处引号已去掉
        keyValues.put(AlipayConfig.BIZ_CONTENT, "{\"" + AlipayConfig.NOTIFY_URL + "\":\""
                + NOTIFY_URL_VALUE + "\"," + AlipayConfig.TIMEOUT_EXPRESS + ":\""
                + AlipayConfig.TIMEOUT_EXPRESS_VALUE + "\"," + AlipayConfig.PRODUCT_CODE + ":\""
                + AlipayConfig.PRODUCT_CODE_VALUE + "\"," + AlipayConfig.TOTAL_AMOUNT + ":\"" + amount + "\","
                + AlipayConfig.SUBJECT + ":\"" + AlipayConfig.SUBJECT_VALUE + "\"," + AlipayConfig.BODY + ":\""
                + AlipayConfig.BODY_VALUE + "\"," + AlipayConfig.OUT_TRADE_NO + ":\"" + code + "\"}");

        keyValues.put(AlipayConfig.CHARSET, AlipayConfig.CHARSET_VALUE);

        keyValues.put(AlipayConfig.METHOD, AlipayConfig.METHOD_VALUE);

        keyValues.put(AlipayConfig.SIGN_TYPE, AlipayConfig.SIGN_TYPE2_VALUE);

        keyValues.put(AlipayConfig.TIMESTAMP, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        keyValues.put(AlipayConfig.VERSION, AlipayConfig.VERSION_VALUE);

        return keyValues;
    }

    /**
     * 拼接键值对
     *
     * @param key
     * @param value
     * @param isEncode
     * @return
     */
    private static String buildKeyValue(String key, String value, boolean isEncode) {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("=");
        if (isEncode) {
            try {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                sb.append(value);
            }
        } else {
            sb.append(value);
        }
        return sb.toString();
    }

    /**
     * 同getSplicingParam()方法一样
     * 拼接成带签名的字符串 （拼接的字符串需要转码）
     *
     * @param map 支付订单参数
     * @return 拼接字符串
     */
    public static String buildSplicingParam(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<String>(map.keySet());
        // key排序
        Collections.sort(keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = map.get(key);
            sb.append(buildKeyValue(key, value, true));
            sb.append("&");
        }

        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        sb.append(buildKeyValue(tailKey, tailValue, true));

        return sb.toString();
    }

    /**
     * 同 buildSplicingParam()方法一样
     * 拼接成待签名的字符串（拼接的字符串不需要转码）
     *
     * @param map
     * @return splicing 拼接好的字符串
     */
    public static String getSplicingParam(Map<String, String> map) {
        StringBuilder splicing = new StringBuilder();
        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = map.get(key);
            splicing.append(buildKeyValue(key, value, false));
            splicing.append("&");
        }
        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        splicing.append(buildKeyValue(tailKey, tailValue, false));
        return splicing.toString();
    }

    /**
     * 除去数组中的空值和签名参数
     *
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<String, String>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    /**
     * 对拼接好的参数进行签名(RSA2 2048 需要转码的签名)
     *
     * @param splicingParam true为rsa2 false为rsa
     * @param privatekey    私钥
     * @param splicingParam 拼接好的字符串
     * @return 转码后的sign
     */
    public static String getRequestAppSign(String splicingParam, String privatekey, boolean rsa) {

        String oriSign = RSA.sign(splicingParam, privatekey, rsa);
        String encodedSign = "";
        try {
            // 签名转码
            encodedSign = URLEncoder.encode(oriSign, "UTF-8");
            log.debug("去签名的参数最后转码：" + encodedSign);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedSign;

    }

    /**
     * 生成签名结果（签名不需要转码（RSA UTF-8）PC）
     *
     * @param splicing 要签名的数组
     * @return 签名结果字符串
     */
    public static String buildRequestMysign(String splicing, String privatekey) {
        String mysign = RSA.sign(splicing, privatekey);
        return mysign;
    }

    /*    ==============================================================================================*/

    /**
     * 初始化PC请求支付宝的数据
     *
     * @param out_trade_no 订单编号
     * @param newamount    支付金额
     * @return map封装的map对象
     */
    public static Map<String, String> initPCRequestParam(String out_trade_no, String newamount) {

        Map<String, String> sParaTemp = new HashMap<String, String>();

        sParaTemp.put(AlipayConfig.SERVICE, AlipayConfig.SERVICE_VALUE);
        sParaTemp.put(AlipayConfig.PARTNER, AlipayConfig.PARTNER_VLAUE);
        sParaTemp.put(AlipayConfig.SELLER_ID, AlipayConfig.SELLER_ID_VALUE);
        sParaTemp.put(AlipayConfig._INPUT_CHARSET, AlipayConfig.CHARSET_VALUE);
        sParaTemp.put(AlipayConfig.PAYMENT_TYPE, AlipayConfig.PAYMENT_TYPE_VALUE);
        sParaTemp.put(AlipayConfig.NOTIFY_URL, AlipayConfig.PCNOTIFY_URL_VALUE);
        sParaTemp.put(AlipayConfig.RETURN_URL, AlipayConfig.RETURN_URL_VALUE);
        sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
        sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
        sParaTemp.put(AlipayConfig.OUT_TRADE_NO, out_trade_no);
        sParaTemp.put(AlipayConfig.SUBJECT, AlipayConfig.SUBJECT_VALUE);
        sParaTemp.put(AlipayConfig.TOTAL_FEE, newamount);
        sParaTemp.put(AlipayConfig.BODY, AlipayConfig.BODY_VALUE);

        return sParaTemp;
    }


    /**
     * 要求外部订单号必须唯一。
     *
     * @return
     */
    private static String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        String outtradeno = key.substring(0, 15);
        return outtradeno;
    }


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(AlipayConfig.log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成文件摘要
     *
     * @param strFilePath      文件路径
     * @param file_digest_type 摘要算法
     * @return 文件摘要结果
     */
    public static String getAbstract(String strFilePath, String file_digest_type) throws IOException {
        PartSource file = new FilePartSource(new File(strFilePath));
        if (file_digest_type.equals("MD5")) {
            //return DigestUtils.md5Hex(file.createInputStream());
        } else if (file_digest_type.equals("SHA")) {
            //return DigestUtils.sha256Hex(file.createInputStream());
        } else {
            return "";
        }
        // 后加的
        return null;
    }

}
