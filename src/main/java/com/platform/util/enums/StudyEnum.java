package com.platform.util.enums;

import java.util.Arrays;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/9 12:18
 */
public enum StudyEnum {
    ORDER_NO(0, "出错了"),
    COURSE_CENTER(1,"课程中心"),
    STUDY_VIDEO(2,"学习视频"),
    STUDY_BOOK(3,"学习手册"),
    INDUSTRY_CASE(4,"行业案例"),
    INDUSTRY_BG(6,"运动背景图"),
    INDUSTRY_VSPC(7,"VSPC介绍"),
    INDUSTRY_ENERGY(8,"能量介绍");
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

    StudyEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public static String getDesc(int key) {
        StudyEnum result = Arrays.stream(StudyEnum.values()).filter(state -> state.getKey() == key).findFirst().orElse(StudyEnum.ORDER_NO);
        return result.getValue();

    }
}
