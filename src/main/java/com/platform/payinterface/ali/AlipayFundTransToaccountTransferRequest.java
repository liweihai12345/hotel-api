package com.platform.payinterface.ali;

import com.alipay.api.AlipayObject;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.payinterface.ali.config.AlipayConfig;
import com.platform.payinterface.ali.sign.RSA;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 商家向支付宝用户转账退款参数类
 *
 * @author 李卫海
 */
public class AlipayFundTransToaccountTransferRequest implements AlipayRequest<AlipayResponse> {

    public String getApiMethodName() {
        return "alipay.fund.trans.toaccount.transfer";
    }

    public String getApiVersion() {
        return "1.0";
    }

    public AlipayObject getBizModel() {
        return null;
    }

    public String getNotifyUrl() {
        return "http://59.110.23.13/oow/api/pay/alipaynotify.do";
    }

    public String getProdCode() {

        return null;
    }

    public Class<AlipayResponse> getResponseClass() {
        return null;
    }

    public String getReturnUrl() {
        return "http://59.110.23.13/oow/pay/returnurl.do";
    }

    public String getTerminalInfo() {
        return null;
    }

    public String getTerminalType() {
        return null;
    }

    public Map<String, String> getTextParams() {
        Map<String, String> keyValues = new HashMap<String, String>();

        keyValues.put(AlipayConfig.APP_ID, AlipayConfig.APP_ID_VALUE);
        // 此处引号已去掉
        keyValues.put(AlipayConfig.BIZ_CONTENT, this.getBizContent());


        keyValues.put(AlipayConfig.CHARSET, AlipayConfig.CHARSET_VALUE);

        keyValues.put(AlipayConfig.METHOD, AlipayConfig.METHOD_VALUE_TRANSFER);

        keyValues.put(AlipayConfig.SIGN_TYPE, AlipayConfig.SIGN_TYPE2_VALUE);

        keyValues.put(AlipayConfig.TIMESTAMP, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        keyValues.put(AlipayConfig.VERSION, AlipayConfig.VERSION_VALUE);
        return keyValues;
    }

    public boolean isNeedEncrypt() {
        return false;
    }

    public void setApiVersion(String arg0) {

    }

    public void setBizModel(AlipayObject arg0) {

    }

    public void setNeedEncrypt(boolean arg0) {

    }

    public void setNotifyUrl(String arg0) {

    }

    public void setProdCode(String arg0) {

    }

    public void setReturnUrl(String arg0) {

    }

    public void setTerminalInfo(String arg0) {

    }

    public void setTerminalType(String arg0) {

    }


    /**
     * 构造支付订单参数列表
     *
     * @return
     */
    public static String getBizContent() {
        String param = "{" +
                "    \"out_biz_no\":\"3142321423432\"," +
                "    \"payee_type\":\"ALIPAY_LOGONID\"," +
                "    \"payee_account\":\"13522750075\"," +
                "    \"amount\":\"0.01\"," +
                "    \"payer_real_name\":\"上海交通卡公司\"," +
                "    \"payer_show_name\":\"上海交通卡退款\"," +
                "    \"payee_real_name\":\"张三\"," +
                "    \"remark\":\"转账备注\"," +
                "    \"ext_param\":\"{\\\"order_title\\\":\\\"上海交通卡退款\\\"}\"" +
                "  }";
        return param;
    }

    /**
     * @param out_biz_no  商家转账单号商家生成
     * @param userAccount 用户账号
     * @param amount      金额
     * @param payername   公司名称账号姓名
     * @param payshowname 显示给用户的姓名或公司名称+业务名
     * @param username    用户的真实姓名
     * @param remark      备注
     * @param jsonParam   转换完成的json 字符串
     * @return
     */
    public static String getParam(String out_biz_no, String userAccount, String amount, String payername, String payshowname, String username, String remark, String jsonParam) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(AlipayConfig.OUT_BIZ_NO, out_biz_no);
        map.put(AlipayConfig.PAYEE_TYPE, AlipayConfig.PAYEE_TYPE_VALUE);
        map.put(AlipayConfig.PAYEE_ACCOUNT, userAccount);
        map.put(AlipayConfig.AMOUNT, amount);
        map.put(AlipayConfig.PAYER_REAL_NAME, payername);
        map.put(AlipayConfig.PAYER_SHOW_NAME, payshowname);
        map.put(AlipayConfig.PAYEE_REAL_NAME, username);
        map.put(AlipayConfig.REMARK, remark);
        map.put(AlipayConfig.EXT_PARAM, jsonParam);
        ObjectMapper jsonMaper = new ObjectMapper();
        try {
            String param = jsonMaper.writeValueAsString(map);
            return param;
        } catch (JsonGenerationException e) {

            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 构造支付订单参数信息
     *
     * @param map 支付订单参数
     * @return
     */
    public static String buildOrderParam(Map<String, String> map) {
        List<String> keys = new ArrayList<String>(map.keySet());
        // key排序
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
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

    private String getSign(Map<String, String> keyValues) {

        List<String> keys = new ArrayList<String>(keyValues.keySet());
        // key排序
        Collections.sort(keys);

        StringBuilder authInfo = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = keyValues.get(key);
            authInfo.append(buildKeyValue(key, value, false));
            authInfo.append("&");
        }

        String tailKey = keys.get(keys.size() - 1);
        String tailValue = keyValues.get(tailKey);
        authInfo.append(buildKeyValue(tailKey, tailValue, false));
        // 获取签名
        String oriSign = RSA.sign(authInfo.toString(), AlipayConfig.APP_PRIVATE_KEY);
        String encodedSign = "";
        try {
            // 签名转码
            encodedSign = URLEncoder.encode(oriSign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "sign=" + encodedSign;
    }


}
