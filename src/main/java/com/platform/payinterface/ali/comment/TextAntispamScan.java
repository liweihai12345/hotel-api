package com.platform.payinterface.ali.comment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20180509.TextScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.platform.payinterface.ali.BaseSample;

import java.util.*;

/**
 * Created by hyliu on 16/3/2.
 * 文本检测
 */
public class TextAntispamScan extends BaseSample {

    public static boolean textScan(String content) throws Exception {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
//        DefaultProfile.addEndpoint(getEndPointName(), regionId, "Green", getDomain());
        DefaultProfile.addEndpoint(regionId, "Green", getDomain());

        IAcsClient client = new DefaultAcsClient(profile);

        TextScanRequest textScanRequest = new TextScanRequest();
        textScanRequest.setSysAcceptFormat(FormatType.JSON); // 指定api返回格式
        textScanRequest.setSysMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法
        textScanRequest.setSysEncoding("UTF-8");
        textScanRequest.setSysRegionId(regionId);


        List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
        Map<String, Object> task1 = new LinkedHashMap<String, Object>();
        task1.put("dataId", UUID.randomUUID().toString());
        task1.put("content", content);

        tasks.add(task1);

       /* Map<String, Object> task2 = new LinkedHashMap<String, Object>();
        task2.put("dataId", UUID.randomUUID().toString());
        task2.put("content", "蒙汗药法轮功");

        tasks.add(task2);

        Map<String, Object> task3 = new LinkedHashMap<String, Object>();
        task3.put("dataId", UUID.randomUUID().toString());
        task3.put("content", "正常人");

        tasks.add(task3);*/
        JSONObject data = new JSONObject();
        data.put("scenes", Arrays.asList("antispam"));
        data.put("tasks", tasks);

        textScanRequest.setHttpContent(data.toJSONString().getBytes("UTF-8"), "UTF-8", FormatType.JSON);

        /**
         * 请务必设置超时时间
         */
        textScanRequest.setSysConnectTimeout(3000);
        textScanRequest.setSysReadTimeout(6000);
        try {
            HttpResponse httpResponse = client.doAction(textScanRequest);

            if (httpResponse.isSuccess()) {
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), "UTF-8"));
                if (200 == scrResponse.getInteger("code")) {
                    boolean result = ResultComment.result(scrResponse);
                    return result;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
