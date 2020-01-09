package com.platform.util.enums;

import java.util.Arrays;

public enum EnergyCoinTypeEnum {

    ENERGY_UNKNOWN(0, "未知",
            "https://filecdn.dongdongty.com/detail/transfer.png"),
    COIN_TYPE_REG(1, "普通邀请注册",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_EX(2, "运动得SPC-普通用户",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_CONSUME(3, "成为D-one",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//释放
    COIN_TYPE_EXD(4, "运动得SPC-D-one特权",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_REG_USER(5, "新用户注册",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_DONE_REG(6, "D-one邀请注册",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_JOB(7, "任务奖励",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_EXPRODUCT(8, "兑换商品",
            "https://filecdn.dongdongty.com/detail/exchange.png"),//消耗
    COIN_TYPE_BUY(10, "商城购买产品",
            "https://filecdn.dongdongty.com/detail/shop.png"),//释放
    COIN_TYPE_NORMALSPORT(11, "普通运动返奖励",
            "https://filecdn.dongdongty.com/detail/team-run.png"),
    COIN_TYPE_DONESPORT(12, "Done运动返奖励",
            "https://filecdn.dongdongty.com/detail/team-run.png"),

    //----------------新版-----------------
    ENERGY_SIGN(13, "每日任务-每日签到",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_DYNAMIC(14, "每日任务-发帖",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_COMMENT(15, "每日任务-评论",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_PRAISE(16, "每日任务-点赞",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_CHOICENESS(17, "每日任务-精选内容",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_CLOCK_IN(18, "每周任务-跑步打卡分享",
            "https://filecdn.dongdongty.com/detail/run.png"),
    ENERGY_COMMON_RUN(19, "普通运动",
            "https://filecdn.dongdongty.com/detail/team-run.png"),
    ENERGY_DONE_RUN(20, "Done运动",
            "https://filecdn.dongdongty.com/detail/team-run.png"),
    ENERGY_TEAM_RUN(21, "团队运动奖励",
            "https://filecdn.dongdongty.com/detail/team-run.png"),
    ENERGY_SHOPPING(22, "商城购物赠送",
            "https://filecdn.dongdongty.com/detail/shop.png"),
    ENERGY_INVITE_DONE(23, "推荐D-one",
            "https://filecdn.dongdongty.com/detail/D-one.png"),
    ENERGY_DONE(24, "成为D-one",
            "https://filecdn.dongdongty.com/detail/D-one.png"),

    //以下为能量释放
    ENERGY_SHOPPING_FREE(25, "商城购物释放",
            "https://filecdn.dongdongty.com/detail/shop.png"),
    ENERGY_DATE_FREE(26, "每日释放",
            "https://filecdn.dongdongty.com/detail/free.png"),
    ENERGY_DONE_DONE_FREE(27, "Done用户推荐Done",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//释放
    ENERGY_DONE_GIVE(37, "Done用户推荐Done",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//赠送
    ENERGY_COMMON_DONE_FREE(28, "普通用户推荐Done",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//释放
    ENERGY_COMMON_GIVE(38, "普通用户推荐Done",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//赠送

    //以下为冻结/解冻类型
    FROZEN_BUY(29,"商城购物-冻结",
                       "https://filecdn.dongdongty.com/detail/freeze.png"),//加入冻结(直接赠送的冻结能量值)
    RELIEVE_BUY(30,"商城购物-解除冻结",
                        "https://filecdn.dongdongty.com/detail/shop.png"),//解除冻结(冻结的能量值-->可用能量值)
    FROZEN_BUY_SPC_BACK(31,"商城购物退款-退还能量",
                            "https://filecdn.dongdongty.com/detail/shop.png"),//退还能量(冻结的SPC-->可用能量值)
    FROZEN_BUY_BACK(32,"商城购物退款-退还冻结",
                            "https://filecdn.dongdongty.com/detail/shop.png");//退还冻结(消除购物直接送的冻结能量值)
    private int key;
    private String value;
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    EnergyCoinTypeEnum(int key, String value,String image) {
        this.key = key;
        this.value = value;
        this.image = image;
    }

    public static EnergyCoinTypeEnum getValue(int key) {
        EnergyCoinTypeEnum energy = Arrays.stream(EnergyCoinTypeEnum.values()).filter(o -> o.getKey() == key).findFirst().orElse(EnergyCoinTypeEnum.ENERGY_UNKNOWN);
        return energy;
    }
    public static String getImage(int key) {
        for (EnergyCoinTypeEnum ec : values()) {
            if(ec.getKey() == key)
                return ec.getImage();
        }
        return null;
    }
}
