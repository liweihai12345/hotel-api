package com.platform.util;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/6/28 15:23
 */

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 作用：使用jerseyclient发送http请求。
 * 主要用于调用老平台接口（非微服务架构的）
 */
public class JerseyClientUtil {

    private Client client;

    JerseyClientUtil() {
    }

    /**
     * 静态内部类实现单例模式
     */
    private static class Singleton {
        private static final JerseyClientUtil jerseyClientUtil = new JerseyClientUtil();
    }

    /**
     * 获取单例JerseyClientUtil
     *
     * @return
     */
    public static JerseyClientUtil getJerseyClientUtil() {
        return Singleton.jerseyClientUtil;
    }


    /**
     * 初始化默认的clint对象
     */
    private void setDefaultClient() {
        this.client = ClientBuilder.newClient();
    }


    /**
     * 根据传入的ClientConfig对象初始化client对象
     *
     * @param config
     */
    private void setConfigClient(ClientConfig config) {
        this.client = ClientBuilder.newClient(config);
    }

    /**
     * 根据ClientConfig初始化Client
     *
     * @param config
     */
    private void initClient(ClientConfig config) {
        if (config != null) {
            this.setConfigClient(config);
        } else {
            this.setDefaultClient();
        }
    }

    /**
     * 发送http post请求，返回服务器响应信息
     *
     * @param url    请求的URL
     * @param form   发送的form对象
     * @param config jerseyclient实例的配置信息，可以为空
     * @param tClass 根据此类型处理返回实体
     * @return response Response对象
     */
    public <T> T postInvoke(String url, Form form, ClientConfig config, Class<T> tClass) {

        //初始化Client
        this.initClient(config);

        //发送POST的请求
        //应该对响应实体类进行处理，这样链接才能关闭和回收
        //官方：（https://jersey.github.io/documentation/latest/client.html#d0e5255）The underlying connections are opened for each request and closed after the response is received and entity is processed (entity is read).
        Response response=null;
        try{
            response = client.target(url).request(MediaType.APPLICATION_FORM_URLENCODED)
                    .header("auth", "value")
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        }catch (Exception e){

        }
        if(response==null ||response.getStatus()!=200){
            return null;
        }
        T resultObject = response.readEntity(tClass);
        return resultObject;
    }

    /**
     * 发送http get请求，返回服务器响应信息
     *
     * @param url    请求的URL
     * @param param  参数map
     * @param config jerseyclient实例的配置信息，可以为空
     * @param tClass 根据此类型处理返回实体
     * @return response Response对象
     */
    public <T> T getInvoke(String url, Map<String, Object> param, ClientConfig config, Class<T> tClass) {

        //初始化Client
        this.initClient(config);
        WebTarget webTarget = client.target(url);
        //添加参数
        for (String key : param.keySet()) {
            webTarget = webTarget.queryParam(key, param.get(key));
        }
        Response response=null;
        try{
            response = webTarget.request(MediaType.APPLICATION_JSON).header("auth", "value").get();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(response==null ||response.getStatus()!=200){
            return null;
        }

        T resultObject = response.readEntity(tClass);
        return resultObject;
    }


}
