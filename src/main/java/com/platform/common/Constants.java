package com.platform.common;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/9 12:15
 */
public class Constants {

    /*密钥串*/
    public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK+3gnrhBRNhACZ2" +
            "c431XUAgSEMSmW+gGLurXLilAYnr3rVBEaNCttN5sHUQg6OEcfU4ZgNr0CGX5QEM" +
            "qpA5dlvM8Sp4W+P3QkBDlsUxMw1MPHzYXfa4Bpkxhe9JQeJsHDElwkeq6qwofIMO" +
            "LRFaeFL4Y9X13hANBdXEQzbqdYITAgMBAAECgYAHUSPsy/vzH6Hq+Bm9uo7kgbOg" +
            "n2CmRkthXTRiN/TFcn32nDwIyVllmvafGU3x/Czmoi+VSuMC0xllHsrncI0eGcN0" +
            "kra8fZ/eEJ74YS9H4LxvnmsZyP0aM2NyXEPsEfG6yEgfRq4PmUqRPXiOvZ+ZmQ/l" +
            "KvAGBMNEaixFVQjWwQJBAObcnQUroXRYs34xk19LwNyHyNCAMFKdi4xe3BFpq+Q6" +
            "BfPXEdXaI3l78axdFRhxjKRO1FrOQgHRvE7wYHOigfMCQQDC2bQtLeU7rdLkoTsv" +
            "phi/OZhHBl/bPipl3aXFp5biJRQ2DiXnU0xtIknluXOoVpV8j386tCjGgoFzAgW2" +
            "4OdhAkEAoagL36n8pZ7TGWOXoZxHEWWXjcCllcQyCnoGOb84GVkz/9oy5/+W5aOP" +
            "yDVp5zLj285DTs6tU97MsK4LrA04VwJAb7o7qWhWuHi8o+KbuH/KUuQooBlUn7eu" +
            "wghtRMALMZNHWpOUQmeuPCncK8DCQ/WZ8/moX7XsZ59vsM2pDys5IQJBAOHjUgW9" +
            "VSXOWUNBkBjeqOi3q505Hw7KAIF0USrMM+bxS6gzj4Fn5AQka8KfFPIr+7Z3J4kt" +
            "ZkgmqbccT6h6esc=";
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvt4J64QUTYQAmdnON9V1AIEhD" +
            "EplvoBi7q1y4pQGJ6961QRGjQrbTebB1EIOjhHH1OGYDa9Ahl+UBDKqQOXZbzPEq" +
            "eFvj90JAQ5bFMTMNTDx82F32uAaZMYXvSUHibBwxJcJHquqsKHyDDi0RWnhS+GPV" +
            "9d4QDQXVxEM26nWCEwIDAQAB";
    // banner类型1商城 6排行-首页,7行业案例
    public static final int BANNER_TYPE_PRODUCT = 1,
            BANNER_TYPE_RANK_MAIN = 6,
            BANNER_TYPE_RANK_CASE = 7;
    // banner是否显示（0不显示，1显示）
    public static final int BANNER_VIEW_FLAG_NO = 0, BANNER_VIEW_FLAG_YES = 1;
    // 支付方式：1微信支付，2支付宝支付，3银行卡支付4spc兑换
    public static final int WX_PAY = 1, ALI_PAY = 2, BANK_PAY = 3, SPC_PAY = 4, AMOUNT_PAY = 5;
    // 支付方式：0未支付，2支付
    public static final int PAY_STATUS_NO = 0, PAY_STATUS_YES = 2;
    /* 提款状态 0待处理  1处理中   2已处理  3待核实  */
    public static final int EXTRACT_CASH_STATUS_CREATE = 0, EXTRACT_CASH_STATUS_PROCESS = 1,
            EXTRACT_CASH_STATUS_FINISH = 2, EXTRACT_CASH_STATUS_VERIFY = 3;

    // 合伙人状态：0冻结1正常，1注销，
    public static final int PARTNER_STATUS_FREEZING = 0, PARTNER_STATUS_NORMAL = 1, PARTNER_STATUS_LOGOUT = 1;
    // 合伙人性别：0男，1女
    public static final String VIDEO_TYPE_SHORT = "短视频";
    public static final String VIDEO_TYPE_LONG = "教学视频";
    // 行业案例列表
    public static final int CASE_TYPE_PRIVATE = 0;



    //排行榜集合
    public static final String REDIS_RANK_LIST_KEY = "API_RANK_LIST_KEY:list";


    // 币配置
    public static final String REDIS_COIN_CONFIG_KEY = "API_COIN_CONFIG_KEY:COIN_CONFIG";
    //个人基本信息
    public static final String REDIS_USER_KEY = "API_USER_KEY:USER";
    //健康打卡日签到
    public static final String REDIS_SIGN_DAY_KEY = "API_SIGN_DAY_KEY";
    //健康打卡周签到
    public static final String REDIS_SIGN_WEEK_KEY = "API_SIGN_WEEK_KEY";

    //产品分类
    public static final String REDIS_PRO_CATE_KEY = "API_PRO_CATE_KEY:CATE";
    //团队人员基本信息
    public static final String REDIS_TEAM_KEY = "API_TEAM_KEY:TEAM";

    //短信模板
    public static final String REDIS_SMS_TEMPLATE_KEY = "API_SMS_TEMPLATE_KEY:TEMPLATE";
    //商户信息
    public static final String REDIS_MERCHANT_KEY = "MERCHANT_KEY:MERCHANT:mid";

    public static final String LOGIN_TOKEN_KEY = "token";

    public static final String PAY_PASSWORD_KEY = "PAY_PASSWORD_KEY:userId";

    //首页key
    public static final String REDIS_HOME_BANNER = "HOME_KEY:banner";
    public static final String REDIS_HOME_CATE = "HOME_KEY:cate";
    public static final String REDIS_HOME_PRO = "HOME_KEY:pro";
    //分享字
    public static final String REDIS_SHARE_STR = "SHARE_KEY:str";
    //文字内容配置
    public static final String REDIS_TEXT_CONF = "CONTENT_KEY:text";
    //社区能量规则定义
    public static final String REDIS_DYNAMIC_RULE_KEY = "DYNAMIC_RULE_KEY:btype";
    //社区分类
    public static final String REDIS_COMMUNITY_KEY = "COMMUNITY_KEY:CATE";
    // 个人消息总数量
    public static final String REDIS_NOTICE_KEY = "NOTICE_KEY:userId";
    //上限
    public static final String REDIS_UPPER_KEY = "UPPER_KEY:list";
    //抽奖
    public static final String REDIS_LOTTERY_KEY = "LOTTERY_KEY:type";

    //最新价
    public static final String REDIS_LATEST_KEY = "LATEST_KEY:bid";
    //抢购
    public static final String REDIS_SNAPUP_KEY = "SNAPUP_KEY:activeId";

    public static final String modelTopNameBig="能量值";
    public static final String modelTopNameSmall="每天24点降为0";
    public static final String modelDownNameBig="蓄能值";
    public static final String modelDownNameSmall="7日后降为0";

    public static String getAccessToken(int type) {
        switch (type) {
            case 1:
                return "lotteryhtml_token";
            case 2:
                return "app_token";
        }
        return "app_token";
    }

    // 排名
    public static final String REDIS_RANK_LOCK = "API_RANK_LOCK";
    //竞拍产品
    public static final String REDIS_AUCTION_LOCK = "AUCTION_LOCK:bid";
    //竞拍结果
    public static final String SCHEDULED_AUCTION_LOCK = "SCHEDULED_AUCTION_LOCK";
    //流拍
    public static final String SCHEDULED_PASS_LOCK = "SCHEDULED_PASS_LOCK";
    //释放能量到spc
    public static final String SCHEDULED_RELEASE_COIN_LOCK= "SCHEDULED_RELEASE_COIN_LOCK";
    //日注册快照
    public static final String SCHEDULED_REG_SNAP_LOCK = "SCHEDULED_REG_SNAP_LOCK:REG_SNAP";
    //重置公里数
    public static final String SCHEDULED_RESETKM_LOCK = "SCHEDULED_RESETKM_LOCK:RESETKM";
    //运动链发出总量
    public static final String SCHEDULED_STATISTICS_LOCK = "SCHEDULED_STATISTICS_LOCK:STATISTICS";
    //开始统计运动挖矿奖励
    public static final String REDIS_RUN_REWARD_KEY = "API_REWARD_KEY";
    // 定时取消订单
    public static final String SCHEDULED_CANCEL_ORDER_LOCK = "SCHEDULED_CANCEL_ORDER_LOCK";
    // 定时确认收货
    public static final String REDIS_FINISH_ORDER_KEY = "API_FINISH_ORDER_KEY";
    //变更D-one级别
    public static final String REDIS_DONE_LOCK = "API_DONE_LOCK";

}
