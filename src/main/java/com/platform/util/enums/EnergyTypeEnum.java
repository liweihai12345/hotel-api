package com.platform.util.enums;

public enum EnergyTypeEnum {

    ENERGY_LOGIN_RUN("loginrun","登陆运动"),
    ENERGY_INVITE("inviteuser","邀请新用户"),
    ENERGY_SHOP("shopping","商城购物"),
    ENERGY_TEAM_RUN("teamrun","团队运动"),
    ENERGY_SHARE_PRO("sharepro","分享产品"),
    ENERGY_SHOP_EVA("shopcomment","购物评价"),
    ENERGY_SHOP_CHILD("childshop","下级购物"),
    ENERGY_DONE("recommend","推荐D-one");

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    EnergyTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
