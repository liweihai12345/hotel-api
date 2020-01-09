package com.platform.payinterface;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.platform.payinterface.ali.config.AlipayConfig;
import com.platform.payinterface.ali.util.AlyParamUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class AlyAppPayStrategy implements IPayStrategy {
    @Override
    public Map<String, String> buildAppResponseParam(String code, String newamount) {
        // 构建订单请求参数MAP
        Map<String, String> params = AlyParamUtil.initAppParamMap(code, newamount);
        log.debug("支付宝支付初始化的参数：" + params);
        // 没有 去除 空值 关键字等 做字符拼接
        String splicing = AlyParamUtil.getSplicingParam(params);
        log.debug("支付宝对初始化的参数拼接：" + splicing);
        // 获取签名
        String sign = AlyParamUtil.getRequestAppSign(splicing, AlipayConfig.APP_PRIVATE_KEY, true);
        log.debug("支付宝的签名结果：" + sign);
        //此处可能重复buildSplicingParam()和 getSplicingParam()重复了
        //此数据未用到
        String payParam = AlyParamUtil.buildSplicingParam(params);

//        params.put(AlipayConfig.SUBJECT, AlipayConfig.SUBJECT_VALUE);
//        params.put(AlipayConfig.BODY, AlipayConfig.BODY_VALUE);
//        params.put(AlipayConfig.TOTAL_AMOUNT, newamount);
//        params.put(AlipayConfig.OUT_TRADE_NO, code);
//        params.put(AlipayConfig.SIGN, sign);
        params.put(AlipayConfig.PAYPARAM, payParam + "&sign=" + sign);
        log.debug("APP支付宝最终返回的数据：" + params);
        return params;
    }

    /**
     * 支付宝rsa2验签
     */
    @Override
    public Boolean buildNotifyVerify(Map<String, String> params) {

        try {
            log.debug("APIsignVerified 支付宝准备验签sign:" + params.get("sign"));
            Map<String, String> map = AlyParamUtil.paraFilter(params);
            String content = AlyParamUtil.getSplicingParam(map);
            log.debug("APIsignVerified 支付宝待验签参数：" + content);
            boolean signVerified = AlipaySignature.rsaCheck(content, params.get("sign"), AlipayConfig.ALIPAY_APP_PUBLIC_KEY, "UTF-8", AlipayConfig.SIGN_TYPE2_VALUE);
            return signVerified;
        } catch (AlipayApiException e) {
            e.printStackTrace();
            log.error("进入支付宝aliApiException:" + e.getMessage());
        } catch (Exception e) {
            log.error("进入支付宝Exception：" + e.getMessage());
        }
        return false;
    }

}
