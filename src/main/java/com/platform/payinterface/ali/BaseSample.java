package com.platform.payinterface.ali;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by liuhai.lh on 17/01/12.
 */
public class BaseSample {



    protected static String regionId="cn-beijing";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    protected static final String accessKeyId = "LTAIwTNsbRQVqjRK";
    protected static final String accessKeySecret = "j8AXtMQNxNvagddwMqBU5W4xBbNd0s";
//    protected static final String accessKeyId = "LTAIqjEaD6vxX5M8";
//    protected static final String accessKeySecret = "RpKYrA4KrWq8V939jh5wMVZZrsGoMa";

    protected static String getDomain(){
         if("cn-shanghai".equals(regionId)){
             return "green.cn-shanghai.aliyuncs.com";
         }

         if ("cn-beijing".equals(regionId)) {
            return "green.cn-beijing.aliyuncs.com";
         }

         if ("ap-southeast-1".equals(regionId)) {
            return "green.ap-southeast-1.aliyuncs.com";
         }

         if ("us-west-1".equals(regionId)) {
            return "green.us-west-1.aliyuncs.com";
         }

         return "green.cn-shanghai.aliyuncs.com";
    }

    protected static String getEndPointName(){
        return regionId;
    }

}
