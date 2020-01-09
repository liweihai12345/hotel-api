package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/11 9:59
 */
public enum FileTypeEnum {
    FILE_TYPE_LOGO(1, "头像"),
    FILE_TYPE_IMAGE(2, "反馈图片"),
    FILE_TYPE_PRO(3, "产品图片"),
    FILE_TYPE_VIDEO(4, "短视频"),
    FILE_TYPE_COMMENT(5, "评论"),
    FILE_TYPE_NEW(6, "新闻资讯"),
    FILE_TYPE_ACTIVITY(7, "活动"),
    FILE_TYPE_IDCARD(8, "身份证"),;
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

    FileTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }


}
