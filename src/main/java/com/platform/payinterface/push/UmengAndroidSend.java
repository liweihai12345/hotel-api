package com.platform.payinterface.push;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.platform.entity.NotificationDO;
import com.platform.entity.NotificationRecordDO;
import com.platform.payinterface.push.android.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class UmengAndroidSend {
    private String appkey = null;
    private String appMasterSecret = null;
    private static boolean IS_PRODUCTION = false;
    private PushClient client = new PushClient();

    public UmengAndroidSend(String key, String secret) {
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
    public void sendAndroidUnicast(NotificationRecordDO action, String token) throws Exception {
        AndroidUnicast unicast = new AndroidUnicast(appkey, appMasterSecret);
        // TODO Set your device token
        unicast.setDeviceToken(token);
        unicast.setTicker(action.getTicker());
        unicast.setTitle(action.getTitle());
        unicast.setText(action.getBody());
        unicast.goAppAfterOpen();
        // unicast.goCustomAfterOpen(JSON.toJSONString(action));
        unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        // TODO Set 'production_mode' to 'false' if it's a test device.
        // For how to register a test device, please see the developer doc.
        unicast.setProductionMode(IS_PRODUCTION);
        unicast.setExtraField("id", String.valueOf(action.getId()));
        unicast.setExtraField("type", action.getType());
        unicast.setExtraField("linkUrl", action.getLinkUrl());
        unicast.setExtraField("targetId", String.valueOf(action.getTargetType()));
        unicast.setDescription(action.getBody());
        client.send(unicast);
    }

    /**
     * 广播(broadcast)：
     *
     * @param action
     * @return
     * @throws Exception
     */

    public boolean sendAndroidBroadcast(NotificationDO action) throws Exception {
        AndroidBroadcast broadcast = new AndroidBroadcast(appkey, appMasterSecret);

        broadcast.setTicker(UmengKeyConstant.TargetType.getValue(action.getKey()));
        broadcast.setTitle(action.getTitle());
        broadcast.setText(action.getBody());
        broadcast.setExtraField("type", action.getKey());
        broadcast.setExtraField("linkUrl", action.getLinkUrl());
        if (true) {
            broadcast.goAppAfterOpen();
        }
        broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
//		broadcast.setProductionMode();
        broadcast.setTestMode();
        return client.send(broadcast);
    }

    /**
     * 自定义播(customizedcast)：文件播
     *
     * @param action
     * @return
     * @throws Exception
     */
    public boolean sendAndroidCustomizedcastFile(NotificationDO action, List<String> list) throws Exception {
        AndroidCustomizedcastFile customizedcast = new AndroidCustomizedcastFile(appkey, appMasterSecret);

        String castFile = StringUtils.join(list, "\n");
        String fileId = client.uploadContents(appkey, appMasterSecret, castFile);
        customizedcast.setFileId(fileId, "alias_type");
        customizedcast.setTicker(action.getTicker());
        customizedcast.setTitle(action.getTitle());
        customizedcast.setText(action.getBody());
        if (true) {
            customizedcast.goAppAfterOpen();
        }
        customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        customizedcast.setProductionMode(IS_PRODUCTION);
        customizedcast.setExtraField("id", String.valueOf(action.getId()));
        customizedcast.setExtraField("type", action.getType().toString());
        customizedcast.setExtraField("linkUrl", action.getLinkUrl());
        customizedcast.setExtraField("targetId", String.valueOf(action.getTargetType()));
        customizedcast.setDescription(action.getBody());
        boolean result = client.send(customizedcast);
        return result;
    }

    /**
     * 组播(groupcast)
     *
     * @throws Exception
     */
    public void sendAndroidGroupcast() throws Exception {
        AndroidGroupcast groupcast = new AndroidGroupcast(appkey, appMasterSecret);
        /*  TODO
         *  Construct the filter condition:
         *  "where":
         *	{
         *		"and":
         *		[
         *			{"tag":"test"},
         *			{"tag":"Test"}
         *		]
         *	}
         */
        JSONObject filterJson = new JSONObject();
        JSONObject whereJson = new JSONObject();
        JSONArray tagArray = new JSONArray();
        JSONObject testTag = new JSONObject();
        JSONObject TestTag = new JSONObject();
        testTag.put("tag", "test");
        TestTag.put("tag", "Test");
        tagArray.add(testTag);
        tagArray.add(TestTag);
        whereJson.put("and", tagArray);
        filterJson.put("where", whereJson);
        System.out.println(filterJson.toString());

        groupcast.setFilter(filterJson);
        groupcast.setTicker("Android groupcast ticker");
        groupcast.setTitle("中文的title");
        groupcast.setText("Android groupcast text");
        groupcast.goAppAfterOpen();
        groupcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        // TODO Set 'production_mode' to 'false' if it's a test device.
        // For how to register a test device, please see the developer doc.
        groupcast.setProductionMode();
        client.send(groupcast);
    }

    /**
     * 自定义播(customizedcast)：
     *
     * @throws Exception
     */
    public void sendAndroidCustomizedcast() throws Exception {
        AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(appkey, appMasterSecret);
        // TODO Set your alias here, and use comma to split them if there are multiple alias.
        // And if you have many alias, you can also upload a file containing these alias, then
        // use file_id to send customized notification.
        customizedcast.setAlias("5", "alias_type");
        customizedcast.setTicker("Android customizedcast ticker");
        customizedcast.setTitle("中文的title");
        customizedcast.setText("Android customizedcast text");
        customizedcast.goAppAfterOpen();
        customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        // TODO Set 'production_mode' to 'false' if it's a test device.
        // For how to register a test device, please see the developer doc.
//		customizedcast.setProductionMode();
        customizedcast.setTestMode();
        client.send(customizedcast);
    }

    /**
     * 文件播(filecast)
     *
     * @throws Exception
     */
    public void sendAndroidFilecast() throws Exception {
        AndroidFilecast filecast = new AndroidFilecast(appkey, appMasterSecret);
        // TODO upload your device tokens, and use '\n' to split them if there are multiple tokens
        String fileId = client.uploadContents(appkey, appMasterSecret, "aa" + "\n" + "bb");
        filecast.setFileId(fileId);
        filecast.setTicker("Android filecast ticker");
        filecast.setTitle("中文的title");
        filecast.setText("Android filecast text");
        filecast.goAppAfterOpen();
        filecast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        client.send(filecast);
    }
}
