package com.platform.payinterface.push.ios;


import com.platform.payinterface.push.IOSNotification;

public class IOSCustomizedCast extends IOSNotification {
    public IOSCustomizedCast(String appkey, String appMasterSecret) throws Exception {
        setAppMasterSecret(appMasterSecret);
        setPredefinedKeyValue("appkey", appkey);
        this.setPredefinedKeyValue("type", "customizedcast");
    }

    public void setAlias(String alias, String aliasType) throws Exception {
        setPredefinedKeyValue("alias", alias);
        setPredefinedKeyValue("alias_type", aliasType);
    }

}
