package com.platform.payinterface.ali.util;

import com.platform.payinterface.ali.config.AlipayConfig;
import com.platform.payinterface.ali.sign.RSA;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* *
 *类名：AlipayNotify
 *功能：支付宝通知处理类
 *详细：处理支付宝各接口通知返回
 *版本：3.3
 *日期：2012-08-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考

 *************************注意*************************
 *调试通知返回时，可查看或改写log日志的写入TXT里的数据，来检查通知返回是否正常
 */

/**
 * 支付宝通知处理类主要做验证
 *
 * @author 李卫海
 */
@Slf4j
public class AlipayNotify {

    /**
     * 验证消息是否是支付宝发出的合法消息
     *
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params) {
        log.debug("支付宝校验签名begin");
        // 判断responsetTxt和isSign是否为true
        // responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        // isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
        String responseTxt = "false";
        if (params.get("notify_id") != null) {
            String notify_id = params.get("notify_id");
            responseTxt = verifyResponse(notify_id);
        }
        String sign = "";
        if (params.get("sign") != null) {
            sign = params.get("sign");
        }
        boolean isSign = getSignVeryfy(params, sign);

        // 写日志记录（若要调试，请取消下面两行注释）
        // AlipayCore.logResult(sWord);
        log.debug("支付宝签名校验结果end：" + isSign);
        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     *
     * @param Params  通知返回来的参数数组
     * @param alysign 比对的签名结果
     * @return 生成的签名结果
     */
    private static boolean getSignVeryfy(Map<String, String> Params, String alysign) {
        // 过滤空值、sign与sign_type参数
        Map<String, String> sParaNew = AlyParamUtil.paraFilter(Params);
        // 获取待签名字符串
        String splicingStr = AlyParamUtil.getSplicingParam(sParaNew);
        log.warn("待校验的参数：" + splicingStr);

        // 获得签名验证结果
        boolean isSign = RSA.verify(splicingStr, alysign, AlipayConfig.ALIPAY_PC_PUBLIC_KEY,
                AlipayConfig.CHARSET_VALUE, AlipayConfig.SIGN_TYPE_VALUE, AlipayConfig.SIGN_ALGORITHMS);
        log.warn("校验签名的结果：" + isSign);

        return isSign;
    }

    /**
     * 获取远程服务器ATN结果,验证返回URL
     *
     * @param notify_id 通知校验ID
     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
     * 返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String verifyResponse(String notify_id) {
        // 获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
        String partner = AlipayConfig.PARTNER_VLAUE;
        String veryfy_url = AlipayConfig.HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

        return checkUrl(veryfy_url);
    }

    /**
     * 获取远程服务器ATN结果
     *
     * @param urlvalue 指定URL路径地址
     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
     * 返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String checkUrl(String urlvalue) {
        log.debug("获取远程服务器ATN结果");
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }
        log.debug("获取远程服务器ATN结果准备返回");
        return inputLine;
    }
}
