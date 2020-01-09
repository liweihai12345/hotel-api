package com.platform.payinterface.push;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashSet;

public abstract class IOSNotification extends UmengNotification {

    // Keys can be set in the aps level
    protected static final HashSet<String> APS_KEYS = new HashSet<String>(Arrays.asList(new String[]{
            "alert", "badge", "sound", "content-available"
    }));
    // Keys can be set in the body level
    protected static final HashSet<String> BODY_KEYS = new HashSet<String>(Arrays.asList(new String[]{
            "after_open", "url", "activity", "custom"}));

    @Override
    public boolean setPredefinedKeyValue(String key, Object value) throws Exception {
        if (ROOT_KEYS.contains(key)) {
            // This key should be in the root level
            rootJson.put(key, value);
        } else if (APS_KEYS.contains(key)) {
            // This key should be in the aps level
            JSONObject apsJson = null;
            JSONObject payloadJson = null;
            if (rootJson.containsKey("payload")) {
                payloadJson = rootJson.getJSONObject("payload");
            } else {
                payloadJson = new JSONObject();
                rootJson.put("payload", payloadJson);
            }
            if (payloadJson.containsKey("aps")) {
                apsJson = payloadJson.getJSONObject("aps");
            } else {
                apsJson = new JSONObject();
                payloadJson.put("aps", apsJson);
            }
            apsJson.put(key, value);
        } else if (BODY_KEYS.contains(key)) {
            // This key should be in the aps level
            JSONObject bodyJson = null;
            JSONObject payloadJson = null;
            if (rootJson.containsKey("payload")) {
                payloadJson = rootJson.getJSONObject("payload");
            } else {
                payloadJson = new JSONObject();
                rootJson.put("payload", payloadJson);
            }
            if (payloadJson.containsKey("body")) {
                bodyJson = payloadJson.getJSONObject("body");
            } else {
                bodyJson = new JSONObject();
                payloadJson.put("aps", bodyJson);
            }
            bodyJson.put(key, value);
        } else if (POLICY_KEYS.contains(key)) {
            // This key should be in the body level
            JSONObject policyJson = null;
            if (rootJson.containsKey("policy")) {
                policyJson = rootJson.getJSONObject("policy");
            } else {
                policyJson = new JSONObject();
                rootJson.put("policy", policyJson);
            }
            policyJson.put(key, value);
        } else {
            if (key == "payload" || key == "aps" || key == "policy") {
                throw new Exception("You don't need to set value for " + key + " , just set values for the sub keys in it.");
            } else {
                throw new Exception("Unknownd key: " + key);
            }
        }

        return true;
    }

    // Set customized key/value for IOS notification
    public boolean setCustomizedField(String key, String value) throws Exception {
        //rootJson.put(key, value);
        JSONObject payloadJson = null;
        if (rootJson.containsKey("payload")) {
            payloadJson = rootJson.getJSONObject("payload");
        } else {
            payloadJson = new JSONObject();
            rootJson.put("payload", payloadJson);
        }
        payloadJson.put(key, value);
        return true;
    }

    public void setAlert(String token) throws Exception {
        setPredefinedKeyValue("alert", token);
    }

    public void setBadge(Integer badge) throws Exception {
        setPredefinedKeyValue("badge", badge);
    }

    public void setSound(String sound) throws Exception {
        setPredefinedKeyValue("sound", sound);
    }

    public void setContentAvailable(Integer contentAvailable) throws Exception {
        setPredefinedKeyValue("content-available", contentAvailable);
    }

    public enum AfterOpenAction {
        go_app,//打开应用
        go_url,//跳转到URL
        go_activity,//打开特定的activity
        go_custom//用户自定义内容。
    }

    ///点击"通知"的后续行为，默认为打开app。
    public void goAppAfterOpen() throws Exception {
        setAfterOpenAction(AfterOpenAction.go_app);
    }

    public void goUrlAfterOpen(String url) throws Exception {
        setAfterOpenAction(AfterOpenAction.go_url);
        setUrl(url);
    }

    public void goActivityAfterOpen(String activity) throws Exception {
        setAfterOpenAction(AfterOpenAction.go_activity);
        setActivity(activity);
    }

    public void goCustomAfterOpen(String custom) throws Exception {
        setAfterOpenAction(AfterOpenAction.go_custom);
        setCustomField(custom);
    }

    public void goCustomAfterOpen(JSONObject custom) throws Exception {
        setAfterOpenAction(AfterOpenAction.go_custom);
        setCustomField(custom);
    }

    ///点击"通知"的后续行为，默认为打开app。原始接口
    public void setAfterOpenAction(AfterOpenAction action) throws Exception {
        setPredefinedKeyValue("after_open", action.toString());
    }

    public void setUrl(String url) throws Exception {
        setPredefinedKeyValue("url", url);
    }

    public void setActivity(String activity) throws Exception {
        setPredefinedKeyValue("activity", activity);
    }

    ///can be a string of json
    public void setCustomField(String custom) throws Exception {
        setPredefinedKeyValue("custom", custom);
    }

    public void setCustomField(JSONObject custom) throws Exception {
        setPredefinedKeyValue("custom", custom);
    }


}
