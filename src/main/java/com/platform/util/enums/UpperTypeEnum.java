package com.platform.util.enums;

import java.util.Arrays;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum UpperTypeEnum {

    INVITE_TYPE_NO(0, "普通用户邀请上限"),
    INVITE_TYPE_DONE(1, "D-one邀请上限"),
    BIND_TEAM(2, "团队绑定上限"),
    REWARD_UPPER(3, "邀请奖励上限Done");


    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    UpperTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public static UpperTypeEnum getUpperTypeEnum(int key) {
        UpperTypeEnum result = Arrays.stream(UpperTypeEnum.values()).filter(state -> state.getKey() == key).findFirst().orElse(UpperTypeEnum.INVITE_TYPE_NO);
        return result;

    }
}
