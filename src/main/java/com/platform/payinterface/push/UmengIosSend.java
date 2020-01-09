package com.platform.payinterface.push;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.platform.entity.NotificationDO;
import com.platform.entity.NotificationRecordDO;
import com.platform.payinterface.push.ios.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class UmengIosSend {
    private String appkey = null;
    private static boolean IS_PRODUCTION = false;
    private String appMasterSecret = null;
    private PushClient client = new PushClient();

    public UmengIosSend(String key, String secret) {
        try {
            appkey = key;
            appMasterSecret = secret;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Value("${umeng.prod}")
    public void setIsProduction(boolean production) {
        IS_PRODUCTION = production;
    }

    /**
     * 单播(unicast)
     *
     * @throws Exception
     */
    public void sendIOSUnicast(NotificationRecordDO action, String token) throws Exception {
        IOSUnicast unicast = new IOSUnicast(appkey, appMasterSecret);
        unicast.setDeviceToken(token);
        unicast.setAlert(action.getTicker());
        unicast.setBadge(0);
        unicast.setSound("default");
        // TODO set 'production_mode' to 'true' if your app is under production mode
        unicast.setProductionMode(IS_PRODUCTION);
        unicast.setCustomizedField("id", String.valueOf(action.getId()));
        unicast.setCustomizedField("title", action.getTitle());
        unicast.setCustomizedField("text", action.getBody());
        unicast.setCustomizedField("type", action.getType());
        unicast.setCustomizedField("linkUrl", action.getLinkUrl());
        unicast.setCustomizedField("targetId", String.valueOf(action.getTargetType()));
        unicast.setDescription(action.getBody());
        client.send(unicast);
    }

    /**
     * 广播(broadcast)
     *
     * @param action
     * @return
     * @throws Exception
     */
    public boolean sendIOSBroadcast(NotificationDO action) throws Exception {
        IOSBroadcast broadcast = new IOSBroadcast(appkey, appMasterSecret);
        broadcast.setAlert(action.getTitle());
/*		if(true){
			broadcast.goAppAfterOpen();
		}*/
//		broadcast.setBadge( 0);
        broadcast.setBadge(1);
        broadcast.setSound("default");
        //broadcast.setProductionMode();
        broadcast.setTestMode();
        broadcast.setCustomizedField("type", action.getKey());
        broadcast.setCustomizedField("linkUrl", action.getLinkUrl());
        broadcast.setCustomizedField("ticker", UmengKeyConstant.TargetType.getValue(action.getKey()));
        broadcast.setDescription(action.getBody());
        return client.send(broadcast);
    }

    /**
     * 自定义播文件
     *
     * @param action
     * @return
     * @throws Exception
     */
    public boolean sendIOSCustomizedcastFile(NotificationDO action, List<String> list) throws Exception {
        IOSCustomizedCastFile customizedcast = new IOSCustomizedCastFile(appkey, appMasterSecret);
        String castFile = StringUtils.join(list, "\n");
        String fileId = client.uploadContents(appkey, appMasterSecret, castFile);
        customizedcast.setFileId(fileId, "alias_type");
        customizedcast.setAlert(action.getTitle());
        if (true) {
            customizedcast.goAppAfterOpen();
        }
//		customizedcast.setBadge( 0);
        customizedcast.setBadge(1);
        customizedcast.setSound("default");
        customizedcast.setProductionMode(IS_PRODUCTION);
        customizedcast.setCustomizedField("id", String.valueOf(action.getId()));
        customizedcast.setCustomizedField("title", action.getTitle());
        customizedcast.setCustomizedField("text", action.getBody());
        customizedcast.setCustomizedField("type", String.valueOf(action.getType()));
        customizedcast.setCustomizedField("linkUrl", action.getLinkUrl());
        customizedcast.setCustomizedField("targetId", String.valueOf(action.getTargetType()));
        customizedcast.setDescription(action.getBody());
        boolean result = client.send(customizedcast);

        return result;
    }


    /**
     * 列播(listcast)
     *
     * @throws Exception
     */
    public void sendIOSListcast() throws Exception {
        IOSListcast unicast = new IOSListcast(appkey, appMasterSecret);
        List<String> list = new ArrayList<String>();
        String deviceToken = StringUtils.join(list, ",");
        unicast.setDeviceToken("\"" + deviceToken + "\"");
        unicast.setAlert("IOS 单播测试");
        unicast.setBadge(0);
        unicast.setSound("default");
        // TODO set 'production_mode' to 'true' if your app is under production mode
        unicast.setTestMode();
        // Set customized fields
        unicast.setCustomizedField("test", "helloworld");
        client.send(unicast);
    }

    /**
     * 组播(groupcast)
     *
     * @throws Exception
     */
    public void sendIOSGroupcast() throws Exception {
        IOSGroupcast groupcast = new IOSGroupcast(appkey, appMasterSecret);

        JSONObject filterJson = new JSONObject();
        JSONObject whereJson = new JSONObject();
        JSONArray tagArray = new JSONArray();
        JSONObject testTag = new JSONObject();
        testTag.put("tag", "iostest");
        tagArray.add(testTag);
        whereJson.put("and", tagArray);
        filterJson.put("where", whereJson);


        // Set filter condition into rootJson
        groupcast.setFilter(filterJson);
        groupcast.setAlert("IOS 组播测试");
        groupcast.setBadge(0);
        groupcast.setSound("default");
        // TODO set 'production_mode' to 'true' if your app is under production mode
        groupcast.setTestMode();
        client.send(groupcast);
    }

    /**
     * 自定义播(customizedcast)
     *
     * @throws Exception
     */
    public void sendIOSCustomizedcast() throws Exception {
        IOSCustomizedCast customizedcast = new IOSCustomizedCast(appkey, appMasterSecret);
        // TODO Set your alias and alias_type here, and use comma to split them if there are multiple alias.
        // And if you have many alias, you can also upload a file containing these alias, then
        // use file_id to send customized notification.

        customizedcast.setAlias("31", "alias_type");
        customizedcast.setAlert("IOS 个性化测试");
        customizedcast.setBadge(0);
        customizedcast.setSound("default");
        // TODO set 'production_mode' to 'true' if your app is under production mode
        //customizedcast.setTestMode();
        customizedcast.setProductionMode();
        client.send(customizedcast);
    }

    /**
     * 文件播(filecast)
     *
     * @throws Exception
     */
    public void sendIOSFilecast() throws Exception {
        IOSFilecast filecast = new IOSFilecast(appkey, appMasterSecret);
        // TODO upload your device tokens, and use '\n' to split them if there are multiple tokens
        String fileId = client.uploadContents(appkey, appMasterSecret, "aa" + "\n" + "bb");
        filecast.setFileId(fileId);
        filecast.setAlert("IOS 文件播测试");
        filecast.setBadge(0);
        filecast.setSound("default");
        // TODO set 'production_mode' to 'true' if your app is under production mode
        filecast.setTestMode();
        client.send(filecast);
    }

}
