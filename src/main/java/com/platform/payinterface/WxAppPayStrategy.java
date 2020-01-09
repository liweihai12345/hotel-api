package com.platform.payinterface;

import com.platform.payinterface.wx.WXConstants;
import com.platform.payinterface.wx.WXUtil;
import com.platform.payinterface.wx.XMLUtil;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class WxAppPayStrategy implements IPayStrategy {
    Logger log = LoggerFactory.getLogger(WxAppPayStrategy.class);

    @Override
    public Map<String, String> buildAppResponseParam(String code, String newamount) {
        log.debug("----进入微信支付begin---");
        // 生成xml格式账单
        String xmlEntity = WXUtil.buildWxRequestArgs(code, newamount);
        log.debug("请求微信参数:" + xmlEntity);
        String content = this.wxhttpPost(xmlEntity);
        log.debug("微信返回参数:" + content);
        try {
            Map<String, String> result = XMLUtil.doXMLParse(content);
            Map<String, String> appresult = WXUtil.getAppResponseMap(result);
            log.debug("返回APP参数 未去除关键key和value:" + appresult);
            appresult.remove(WXConstants.APP_ID);
            appresult.remove(WXConstants.MCH_ID);
            log.debug("返回APP最终参数 :" + appresult);
            return appresult;
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private String wxhttpPost(String xmlEntity) {

        // 微信服务端返回结果
        return WXUtil.httpPost(WXConstants.URL, xmlEntity);
    }

    @Override
    public Boolean buildNotifyVerify(Map<String, String> map) {
        // TODO Auto-generated method stub
        return null;
    }

}
