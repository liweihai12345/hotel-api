package com.platform.util.enums;

/**
 * @program:
 * @Description: spc收益配置
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum CoinTypeEnum {

    ENERGY_UNKNOWN(0, "未知",
            "https://filecdn.dongdongty.com/detail/transfer.png"),
    COIN_TYPE_REG(1, "普通邀请注册",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_BACK(2, "退还保证金",
            "https://filecdn.dongdongty.com/detail/enroll.png"),
    COIN_TYPE_ENROLL(3, "缴纳保证金",
            "https://filecdn.dongdongty.com/detail/enroll.png"),
    COIN_TYPE_REG_USER(5, "新用户注册",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_DONE_REG(6, "D-one邀请注册",
            "https://filecdn.dongdongty.com/detail/comment.png"),
    COIN_TYPE_EXPRODUCT(8, "兑换商品",
            "https://filecdn.dongdongty.com/detail/exchange.png"),//消耗
    COIN_TYPE_BUY(10, "商城购买产品",
            "https://filecdn.dongdongty.com/detail/shop.png"),//释放
    COIN_TYPE_NORMALSPORT(11, "普通运动",
            "https://filecdn.dongdongty.com/detail/team-run.png"),
    COIN_TYPE_DONESPORT(12, "Done运动",
            "https://filecdn.dongdongty.com/detail/team-run.png"),
    COIN_TYPE_TRANSIN(13, "收到自+${code}",
            "https://filecdn.dongdongty.com/detail/transfer.png"),//获取
    COIN_TYPE_TRANSOUT(14, "转账给-${code}",
            "https://filecdn.dongdongty.com/detail/transfer.png"),//消耗
    COIN_DATE_FREE(15, "每日释放",
            "https://filecdn.dongdongty.com/detail/free.png"),//释放
    COIN_TYPE_GAME_OUT(16, "游戏消耗",
            "https://filecdn.dongdongty.com/detail/game.png"),//消耗
    COIN_TYPE_DONE(17, "兑换Done",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//消耗
    COIN_TYPE_GAME_IN(18, "游戏奖励",
            "https://filecdn.dongdongty.com/detail/game.png"),//获取
    COIN_COMMON_DONE_FREE(19, "普通用户推荐Done",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//释放 获取
    COIN_DONE_DONE_FREE(20, "Done用户推荐Done",
            "https://filecdn.dongdongty.com/detail/D-one.png"),//释放 获取
    COIN_DONE_TEAM_SHOPPING(21, "团队购物(${code})",
            "https://filecdn.dongdongty.com/detail/shop.png"),//获取

    //以下为冻结/解冻类型
    FROZEN_TEAM_SHOPPING(22,"团队购物(${code})-冻结",
            "https://filecdn.dongdongty.com/detail/freeze.png"),//加入冻结(下级购物直接送的冻结的SPC)
    RELIEVE_TEAM_SHOPPING(23,"团队购物(${code})-解除冻结",
            "https://filecdn.dongdongty.com/detail/shop.png"),//解除冻结(冻结的SPC-->可用的SPC)
    FROZEN_BUY(24,"商城购物-冻结",
                                 "https://filecdn.dongdongty.com/detail/freeze.png"),//加入冻结(可用能量值-->冻结的SPC)
    RELIEVE_BUY(25,"商城购物-解除冻结",
                                  "https://filecdn.dongdongty.com/detail/shop.png"),//解除冻结(冻结的SPC-->可用SPC)
    FROZEN_BUY_BACK(26,"商城购物退款-退还冻结",
                       "https://filecdn.dongdongty.com/detail/shop.png"),//退还冻结(冻结的SPC-->可用能量值)
    RELIEVE_TEAM_SHOPPING_BACK(27,"团队购物退款(${code})-退还冻结",
                        "https://filecdn.dongdongty.com/detail/shop.png"),//退还冻结(消除冻结的SPC)

    ENERGY_SIGN(33, "每日任务-每日签到",
                        "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_DYNAMIC(34, "每日任务-发帖",
                           "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_PRAISE(35, "每日任务-点赞",
                          "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_CHOICENESS(36, "每日任务-精选内容",
                              "https://filecdn.dongdongty.com/detail/comment.png"),
    ENERGY_CLOCK_IN(37, "每周任务-跑步打卡分享",
                            "https://filecdn.dongdongty.com/detail/run.png"),
    ENERGY_TEAM_RUN(38, "团队运动挖矿奖励",
                            "https://filecdn.dongdongty.com/detail/team-run.png"),
    ENERGY_TRANSFORM_SPC(39, "能量值转换SPC",
            "https://filecdn.dongdongty.com/detail/enroll.png");
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

    CoinTypeEnum(int key, String value,String image) {
        this.key = key;
        this.value = value;
        this.image = image;
    }
    public static String getValue(int key) {
        for (CoinTypeEnum ec : values()) {
            if(ec.getKey() == key)
                return ec.getValue();
        }
        return null;
    }
    public static String getImage(int key) {
        for (CoinTypeEnum ec : values()) {
            if(ec.getKey() == key)
                return ec.getImage();
        }
        return null;
    }
}
