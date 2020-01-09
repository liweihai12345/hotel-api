package com.platform.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HTTP请求处理工具类
 * HTTP请求处理工具类
 *
 * @author system
 * @version 1.0
 */
@Slf4j
public class RequestUtil {


    /**
     * 将request查询参数封装至Map
     *
     * @param request  请求
     * @param printLog 是否打印日志
     * @return 参数Map
     */
    public static Map<String, Object> getParameters(HttpServletRequest request,
                                                    boolean printLog) {
        Enumeration<String> enume = request.getParameterNames();
        Map<String, Object> map = new HashMap<String, Object>();
        while (enume.hasMoreElements()) {
            String key = enume.nextElement();
            String value = request.getParameter(key);
            map.put(key, value);
            if (printLog) {
                log.info(key + "==>" + value);
            }
        }
        if (map.get(Global.SORT_ORDER) != null) {
            map.put(Global.SORT_ORDER, "asc");
        }
        return map;
    }

    /**
     * 将request查询参数封装至Map
     *
     * @param request 请求
     * @return 参数Map
     */
    public static Map<String, Object> getParameters(HttpServletRequest request) {

        return getParameters(request, false);
    }


    /**
     * 主要功能:获取请求方IP
     * 注意事项:无
     *
     * @param request 请求
     * @return String IP
     */
    public static String getIpAddrByRequest(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        log.info("x-forwarded-for ip:{}", ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("Proxy-Client-IP ip:{}", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("WL-Proxy-Client-IP ip:{}", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
            log.info("X-Forwarded-For ip:{}", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            log.info("X-Real-IP ip:{}", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.info("RemoteAddr ip:{}", ip);
        }
        return ip;
    }

    /**
     * 获取完整的请求URL
     *
     * @param request 请求
     * @return URL
     */
    public static String getRequestUrl(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }

    /**
     * 主要功能:获取request
     * 注意事项:无
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 主要功能:获取前端请求并转换map
     * 注意事项:无
     *
     * @param request 请求
     * @return 参数map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getBody(HttpServletRequest request) {
        // 获取前台参数
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(
                        inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                }
            }
        }
        body = stringBuilder.toString();
        // 转换成json对象
        JSONObject json = JSONObject.parseObject(body);
        // 转化成map合适
        Map<String, Object> paramers = new HashMap<String, Object>();
        Iterator<Map.Entry<String, Object>> keys = json.entrySet().iterator();

        while (keys.hasNext()) {
            Map.Entry<String, Object> key = keys.next();
            paramers.put(key.getKey(), json.get(key.getValue()));
        }
        return paramers;
    }

}
