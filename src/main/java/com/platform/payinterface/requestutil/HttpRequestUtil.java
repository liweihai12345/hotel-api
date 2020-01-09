package com.platform.payinterface.requestutil;

import com.platform.payinterface.wx.XMLUtil;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpRequestUtil {
    static Logger log = LoggerFactory.getLogger(HttpRequestUtil.class);

    public static Map<String, String> initRequestParam(HttpServletRequest request) {
        log.debug("支付宝异步通知begin");
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iterKey = requestParams.keySet().iterator(); iterKey.hasNext(); ) {
            String name = (String) iterKey.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        return params;
    }

    public static Map<String, String> initWXRequestParam(HttpServletRequest request) {
        log.debug("微信异步通知");
        String xmlString = initWXRequestXmlString(request);
        Map<String, String> map = initWXRequestMap(xmlString);
        return map;
    }

    public static String initWXRequestXmlString(HttpServletRequest request) {
        StringBuffer inputString = new StringBuffer();
        BufferedReader reader = null;
        String line = "";
        String xmlString = null;
        try {
            reader = request.getReader();
            while ((line = reader.readLine()) != null && line.length() > 0) {
                inputString.append(line);
            }
            xmlString = inputString.toString();
            request.getReader().close();
        } catch (IOException e) {
            log.debug("微信回调通知时读取流数据报异常：" + e.getMessage());
            e.printStackTrace();
        }
        return xmlString;
    }

    public static Map<String, String> initWXRequestMap(String xmlString) {
        try {
            Map<String, String> map = XMLUtil.doXMLParse(xmlString);
            return map;
        } catch (JDOMException e) {
            log.debug("微信回调通知时xml转换map数据对象报JDOM异常：" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            log.debug("微信回调通知时xml转换map数据对象报JDOM异常：" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
