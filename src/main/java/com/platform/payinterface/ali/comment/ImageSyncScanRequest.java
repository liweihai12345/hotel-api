package com.platform.payinterface.ali.comment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.platform.payinterface.ali.BaseSample;

import java.util.*;

/**
 * Created by liuhai.lh on 2017/2/17.
 * 图片同步检测接口
 *
 * @author liuhai.lh
 * @date 2017/02/17
 */
public class ImageSyncScanRequest extends BaseSample {


    public static boolean SyncScan(String url) throws Exception {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint( regionId, "Green", getDomain());
        IAcsClient client = new DefaultAcsClient(profile);

        com.aliyuncs.green.model.v20180509.ImageSyncScanRequest imageSyncScanRequest = new com.aliyuncs.green.model.v20180509.ImageSyncScanRequest();
        imageSyncScanRequest.setSysAcceptFormat(FormatType.JSON); // 指定api返回格式
        imageSyncScanRequest.setSysMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法
        imageSyncScanRequest.setSysEncoding("utf-8");
        imageSyncScanRequest.setSysRegionId(regionId);


        List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
        Map<String, Object> task = new LinkedHashMap<String, Object>();
        task.put("dataId", UUID.randomUUID().toString());
        task.put("url", url);
        task.put("time", new Date());

        tasks.add(task);
        JSONObject data = new JSONObject();
        /**
         * porn: 色情
         * terrorism: 暴恐
         * qrcode: 二维码
         * ad: 图片广告
         * ocr: 文字识别
         */
        data.put("scenes", Arrays.asList("porn", "terrorism"));
        data.put("tasks", tasks);

        imageSyncScanRequest.setHttpContent(data.toJSONString().getBytes("UTF-8"), "UTF-8", FormatType.JSON);

        /**
         * 请务必设置超时时间
         */
        imageSyncScanRequest.setSysConnectTimeout(3000);
        imageSyncScanRequest.setSysReadTimeout(6000);

        try {
            HttpResponse httpResponse = client.doAction(imageSyncScanRequest);

            if (httpResponse.isSuccess()) {
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), "UTF-8"));
                boolean result = ResultComment.result(scrResponse);

                return result;
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
