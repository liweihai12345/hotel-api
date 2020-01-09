package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum CoinConfigEnum {

    CONFIG_TYPE_REG(1, "普通邀请注册增链"),
    CONFIG_TYPE_EX(2, "运动得SPC-普通用户"),
    CONFIG_TYPE_CONSUME(3, "Done产品购买后返利"),
    CONFIG_TYPE_EXD(4, "运动得SPC-D-one特权"),
    CONFIG_TYPE_REG_USER(5, "新用户注册"),
    CONFIG_TYPE_DONE_REG(6, "D-one邀请注册"),
    CONFIG_TYPE_JOB(7, "任务配置"),
    CONFIG_TYPE_EXPRODUCT(8, "兑换商品"),
    CONFIG_TYPE_BUY(10, "购买商城产品赠SPC"),
    CONFIG_TYPE_NORMALSPORT(11, "普通用户运动挖矿"),
    CONFIG_TYPE_DONESPORT(12, "D-one用户运动挖矿"),
    CONFIG_TYPE_TRANSIN(13, "SPC转账"),
    CONFIG_TYPE_POWER(14, "产品奖励倍数"),
    CONFIG_TYPE_RELEASE_ONE(15, "普通用户和 D-one每天能量释放千分之一 1‰"),
    CONFIG_TYPE_RELEASE_FIVE(16, "D-one 直接推荐11个D-one能量值释放 5‰"),
    CONFIG_TYPE_POWER_FIFTY(17, "D-one 直接推荐111个D-one 能量值释放 50‰"),
    CONFIG_TYPE_RECOMMEND_ONE(19, "普通用户推荐获得50能量值、奖励 30SPC、释放 20SPC;D-one10倍"),
    CONFIG_TYPE_RECOMMEND_THREE(20, "普通用户推荐3个以上获得50能量值,奖励40SPC,释放30SPC;D-one10倍"),
    CONFIG_TYPE_EXCHANGE_RATIO(21, "每日闪兑数量比例"),
    CONFIG_TYPE_CONVERT(22, "能量兑换SPC比例");
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

    CoinConfigEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public static String getValue(int key) {
        for (CoinConfigEnum ec : values()) {
            if(ec.getKey() == key){
                return ec.getValue();
            }

        }
        return null;
    }
}
