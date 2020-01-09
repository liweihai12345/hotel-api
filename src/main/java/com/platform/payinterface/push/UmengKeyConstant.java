package com.platform.payinterface.push;

import java.util.Arrays;

public class UmengKeyConstant {
    /**
     * 安卓用
     */
    public static final String ANDROID_APPKEY = "5c42fd5ff1f556dc3b00026a";
    public static final String ANDROID_APP_MASTER_SECRET = "qif3exedscyjuf8fha0t1l5zeyfzusth";
    public static final String ANDROID_UMENG_MESSAGE_SECRET = "a7cbcca646e53dded8f157f54b7203f8";
    /**
     * ios用
     */
    public static final String IOS_APPKEY = "5c42fd7fb465f5af2b000e58";
    public static final String IOS_APP_MASTER_SECRET = "lbwbq8scg7vrnunwadxp6d6dumlvnrq4";
    public static final String IOS_UMENG_MESSAGE_SECRET = "lbwbq8scg7vrnunwadxp6d6dumlvnrq4";

    public enum TargetType {
        unkown("unkown", "消息通知"),
        system("DD_SystemOfAnnouncement", "系统公告"),
        message("DD_Message", "私信"),
        comment("DD_Comment", "评论"),
        prise("DD_Prise", "点赞"),
        focus("DD_Focus", "关注"),
        game("DD_Game", "游戏");

        private TargetType(String key, String str) {
            this.type = key;
            this.notification = str;
        }

        private String type;
        private String notification;

        public String getTypeName() {
            return this.notification;
        }

        public String getType() {
            return this.type;
        }

        public static String getValue(String key) {
            TargetType target = Arrays.stream(TargetType.values()).filter(o -> o.getType().equalsIgnoreCase(key)).findFirst().orElse(TargetType.unkown);
            return target.getTypeName();
        }
    }
}
