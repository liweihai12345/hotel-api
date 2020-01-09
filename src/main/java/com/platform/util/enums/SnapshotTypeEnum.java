package com.platform.util.enums;

/**
 * @program:
 * @Description: spc总量配置
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum SnapshotTypeEnum {

    SPC_TYPE_SPORT(1, "运动得SPC总数"),
    SPC_TYPE_TASK(2, "任务得SPC总数"),
    SPC_TYPE_ENERGY(3, "剩余能量值总量"),
    SPC_TYPE_HOLD(4, "用户持有SPC总数"),
    SPC_TYPE_MINER(5, "运动挖矿SPC总数"),
    SPC_TYPE_SHOP(6, "购物送出SPC总数"),
    SPC_TYPE_TOTAL(7, "发放SPC总数");
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


    SnapshotTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(int key) {
        for (SnapshotTypeEnum ec : values()) {
            if (ec.getKey() == key) {
                return ec.getValue();
            }
        }
        return null;
    }
}
