package com.platform.payinterface.push;

import com.platform.entity.NotificationDO;
import com.platform.entity.NotificationRecordDO;

import java.util.List;
import java.util.stream.Collectors;

public class UmengSendUtil {
    /**
     * 单点通知
     *
     * @param action
     * @return
     * @throws Exception
     */
    public static boolean sendMessageUnicast(NotificationRecordDO action, String deviceToken, int type) throws Exception {

        if (type == 1) {
            UmengAndroidSend android = new UmengAndroidSend(UmengKeyConstant.ANDROID_APPKEY, UmengKeyConstant.ANDROID_APP_MASTER_SECRET);
            android.sendAndroidUnicast(action, deviceToken);
        } else {
            UmengIosSend ios = new UmengIosSend(UmengKeyConstant.IOS_APPKEY, UmengKeyConstant.IOS_APP_MASTER_SECRET);
            ios.sendIOSUnicast(action, deviceToken);
        }
        return true;
    }

    /**
     * 广播测试(向安装该App的所有设备发送消息。)
     *
     * @param action
     * @return
     * @throws Exception
     */
    public static boolean sendMessageBroadcast(NotificationDO action) throws Exception {
        UmengAndroidSend android = new UmengAndroidSend(UmengKeyConstant.ANDROID_APPKEY, UmengKeyConstant.ANDROID_APP_MASTER_SECRET);
        UmengIosSend ios = new UmengIosSend(UmengKeyConstant.IOS_APPKEY, UmengKeyConstant.IOS_APP_MASTER_SECRET);
        boolean aresult = android.sendAndroidBroadcast(action);
        boolean iresult = ios.sendIOSBroadcast(action);
        if (aresult && iresult) {
            return true;
        }
        return false;
    }

    /**
     * 自定义播(customizedcast)：开发者通过自有的alias进行推送，可以针对单个或者一批alias进行推送，也可以将alias存放到文件进行发送。
     *
     * @param action
     * @return
     * @throws Exception
     */
    public static boolean sendMessageCustomizedcastFile(NotificationDO action,List<String> list) throws Exception {
        UmengAndroidSend android = new UmengAndroidSend(UmengKeyConstant.ANDROID_APPKEY, UmengKeyConstant.ANDROID_APP_MASTER_SECRET);
        UmengIosSend ios = new UmengIosSend(UmengKeyConstant.IOS_APPKEY, UmengKeyConstant.IOS_APP_MASTER_SECRET);
        List<String> iosList = list.stream().filter(o -> o.length() > 50).collect(Collectors.toList());
        List<String> androidList = list.stream().filter(o -> o.length() < 50).collect(Collectors.toList());
        if(androidList!=null&& androidList.size()>0){
            boolean aresult = android.sendAndroidCustomizedcastFile(action,androidList);
        }
        if(iosList!=null&& iosList.size()>0) {
            boolean iresult = ios.sendIOSCustomizedcastFile(action,iosList);
        }
        return true;
    }
}
