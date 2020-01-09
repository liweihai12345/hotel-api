package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/11 9:59
 */
public enum VideoDynamicTypeEnum {
    VIDEO_TYPE_USER(1, "查看用户(自己或他人)"),
    VIDEO_TYPE_FOCUS(2, "查看关注"),
    VIDEO_TYPE_FIND(3, "查看发现"),
    VIDEO_TYPE_NICE(4, "查看精选"),
    VIDEO_TYPE_COLLECT(5, "查看收藏");
    private Integer key;
    private String value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    VideoDynamicTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }


}
