package com.platform.payinterface.push.android;

import com.alibaba.fastjson.JSONObject;
import com.platform.payinterface.push.AndroidNotification;


public class AndroidGroupcast extends AndroidNotification {
    public AndroidGroupcast(String appkey, String appMasterSecret) throws Exception {
        setAppMasterSecret(appMasterSecret);
        setPredefinedKeyValue("appkey", appkey);
        this.setPredefinedKeyValue("type", "groupcast");
    }

    public void setFilter(JSONObject filter) throws Exception {
        setPredefinedKeyValue("filter", filter);
    }
}
