package com.platform.payinterface.wx;

/**
 * @program:
 * @Description:
 * * 微信接口参数配置
 * 支付宝参数 注意重名
 * @Author: liweihai
 * @Date: Created in 2019/1/12 22:48
 */
public class WXConstants {

        /**
         * appid 微信分配的公众账号ID
         */
        public static final String APP_ID = "appid";

        public static final String APP_ID_VALUE = "wx8ad4d243db951";

        /**
         * 商户号 微信分配的公众账号ID
         */
        public static final String MCH_ID = "mch_id";
//        public static final String MCH_ID_VALUE = "15216401";旧
        public static final String MCH_ID_VALUE = "15240611";

        /**
         * API密钥，在商户平台设置
         */
        public static final String API_KEY = "key";

//        public static final String API_KEY_VALUE = "yundongjiekejiyoi20189";旧
        public static final String API_KEY_VALUE = "yundongjiekejngongsi20189";

//        public static final String APP_SECRET = "cf75d9bd329b0efd9ce50222";旧
        public static final String APP_SECRET = "acfd71e802b648666bbc9d160";

        public static final String CHAR_SET = "UTF-8";
        /**
         * 随机字符串
         */
        public static final String NONCE_STR = "nonce_str";
        /**
         * 签名
         */
        public static final String SIGN = "sign";
        /**
         * 商品描述
         */
        public static final String BODY = "body";
        /**
         * 商户订单号
         */
        public static final String OUT_TRADE_NO = "out_trade_no";
        /**
         * 总金额
         */
        public static final String TOTAL_FEE = "total_fee";
        /**
         * 总金额
         */
        public static final String APP_BODY = "动动体育";

        /**
         * 终端IP
         */
        public static final String SPBILL_CREATE_IP = "spbill_create_ip";
        public static final String SPBILL_CREATE_IP_VALUE = "47.92.2";
        /**
         * 回调通知地址
         */
        public static final String NOTIFY_URL = "notify_url";

        /**
         * 交易类型
         */
        public static final String TRADE_TYPE = "trade_type";
        public static final String TRADE_TYPE_VALUE = "APP";
        /**
         * 返回状态码 成功
         */
        public static final String RETURN_CODE_SUCCESS = "SUCCESS";
        /**
         * 返回状态码 失败
         */
        public static final String RETURN_CODE_FAIL = "FAIL";
        /**
         * URL地址
         */
        public static final String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        // 以下字段在return_code为SUCCESS的时候有返回
        /**
         * 业务结果
         */
        public static final String RESULT_CODE_SUCCESS = "SUCCESS";

        public static final String RETURN_CODE = "return_code";

        public static final String RESULT_CODE = "result_code";
        /**
         * 业务结果
         */
        public static final String RESULT_CODE_FAIL = "FAIL";
        public static final String ERR_CODE = "err_code";
        public static final String ERR_CODE_DES = "err_code_des";
        /**
         * 以下字段在return_code 和result_code都为SUCCESS的时候有返回
         */
        /**
         * 预支付交易会话ID
         */
        public static final String PREPAY_ID = "prepay_id";
        /**
         * 微信生成的交易账号
         */
        public static String PREPAY_ID_VALUE = "";
        /**
         * 付款银行
         */
        public static final String BANK_TYPE = "bank_type";
        /**
         * 现金支付金额
         */
        public static final String CASH_FEE = "cash_fee";
        /**
         * 微信支付订单号
         */
        public static final String TRANSACTION_ID = "transaction_id";
        /**
         * 支付完成时间
         */
        public static final String TIME_END = "time_end";
        /**
         * 扩展字段
         */
        public static final String PACKAGE = "package";
        public static final String PACKAGE_VALUE = "Sign=WXPay";

        /**
         * 时间戳
         */
        public static final String TIME_STAMP = "timestamp";

        public static final Object PARTNER_ID = "partner_id";


        public static final String PARTNERID = "partnerid";

        public static final String NONCESTR = "noncestr";
        public static final String PREPAYID = "prepayid";



    //       app第三方登录 ----------------------------------

    public static final String APPID = "wx8ad4d24d813d1";

    public static final String APPSECRET = "acfd71e802b64856bbc9d160";

    public static final String ACCESS_TOKEN_BASE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    public static final String INFO_BASE_URL = "https://api.weixin.qq.com/sns/userinfo";

    public static final String AUTH_BASE_URL = "https://api.weixin.qq.com/sns/oauth2/authorize";

    public static final String AUTH_valid_URL = "https://api.weixin.qq.com/sns/auth";

    public static final String grant_type = "authorization_code";

    public static final String SCOPE = "snsapi_userinfo";
    public static final String TOKEN = "prepayid";
    public static final String REDIRECT_URL = "prepayid";

    //----------------------jssdk
    //↓微信公众号第三方唯一凭证
    public static final String APPIDJS = "wxec5e79b6f7083";
    //↓第三方用户唯一密匙
    public static final String SECRETJS = "3fe42311560889104d9d65dc79f4";
    //↓获取access_token时调用下方
    public static final String GRANT_TYPE = "client_credential";
    //↓type  jsapi
    public static final String JSAPI_TYPE = "jsapi";
    //↓获取用户基本信息 unionId机制  https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140839
    private static final String USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";

}
