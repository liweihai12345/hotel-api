package com.platform.payinterface.ali.config;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/23 21:15
 */
public class AlipayConfig {
    /**
     * 开放平台应用的APPID
     * 支付宝支付业务：入参app_id
     */
    public static final String APP_ID = "app_id";
    public static final String APP_ID_VALUE = "201902276341";

    //	收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
    /**
     * 支付宝账户登录授权业务：入参pid值  PARTNER
     */
    public static final String PID = "pid";
    public static final String PID_VLAUE = "2088431558432";

    /**
     * 支付宝 开发者应用私钥
     * 商户私钥，pkcs8格式
     */
    public static final String APP_PRIVATE_KEY = "";

    /**
     * APP验签支付宝公钥
     */
    public static final String ALIPAY_APP_PUBLIC_KEY = "MII0BAQEFAAOCAQ8AMIIBCgKCAQEAkZeziOmriGO/PD+HY5r5H0BkMQ3LkobhaJ/uwodWgAT6Zyrlbc3XKFaGAZkI3ZehmeZ8C0rFjtQFWV77yIlQvq+4ihp6b5UrsDQGnB8+tJruNmfyW8qNq4lCRXcQIxVC95w2i/EB1cU36u3N2YJ2IvYBYgkyUTlm2QwUwyPd+3JCjfSlCwTWkHM9VysXde1r/lgatW4gK1berrNmjfVFew19LxBIT+2w8DQWGg22MTf58yFNCxo1WYKO9+UVyGlDKBrnUNSGhCnWezi/lHj/4+9BOmYOLmOYqDiv355tDBT1nC/5H/DUyQTu4gjzh3rBkqOYN4szKkO++cXeta1MMwIDAQAB";


    public static final String ALIPAY_PC_PRIVATE_KEY = "";


    /**
     * 即时支付验签支付宝公钥
     */
    public static final String ALIPAY_PC_PUBLIC_KEY = "MIGfMA0GCSqGSIb3QKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    /**
     * 接口名称
     */
    public static final String METHOD = "method";
    public static final String METHOD_VALUE = "alipay.trade.app.pay";
    /**
     * 仅支持JSON
     */
    public static final String FORMAT = "format";
    public static final String FORMAT_VALUE = "JSON";
    /**
     * 请求和签名使用的字符编码格式，支持GBK和UTF-
     */
    public static final String CHARSET = "charset";
    public static final String CHARSET_VALUE = "utf-8";
    /**
     * 商户生成签名字符串所使用的签名算法类型，目前支持RSA
     */
    public static final String SIGN_TYPE = "sign_type";
    public static final String SIGN_TYPE_VALUE = "RSA";
    public static final String SIGN_TYPE2_VALUE = "RSA2";

    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static final String SIGN_ALGORITHMS2 = "SHA256WithRSA";

    /**
     * 商户请求参数的签名串
     */
    public static final String SIGN = "sign";
    /**
     * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    public static final String TIMESTAMP = "timestamp";
    /**
     * 调用的接口版本，固定为：1.0
     */
    public static final String VERSION = "version";
    public static final String VERSION_VALUE = "1.0";
    /**
     * 支付宝服务器主动通知商户服务器里指定的页面http/https路径。建议商户使用https
     */
    public static final String NOTIFY_URL = "notify_url";

    /**
     * 业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
     */
    public static final String BIZ_CONTENT = "biz_content";
    /**
     * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
     */
    public static final String BODY = "body";
    public static final String BODY_VALUE = "体育订单支付";
    /**
     * 商品的标题/交易标题/订单标题/订单关键字等。
     */
    public static final String SUBJECT = "subject";
    public static final String SUBJECT_VALUE = "体育";
    /**
     * 商户网站唯一订单号
     */
    public static final String OUT_TRADE_NO = "out_trade_no";
    /**
     * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     */
    public static final String TOTAL_AMOUNT = "total_amount";
    /**
     * 销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
     */
    public static final String PRODUCT_CODE = "product_code";
    public static final String PRODUCT_CODE_VALUE = "QUICK_MSECURITY_PAY";
    /**
     * 该交易在支付宝系统中的交易流水号。最长64位
     */
    public static final String TRADE_NO = "trade_no";


    /**
     * 处理结果的描述，信息来自于code返回结果的描述
     */
    public static final String MSG = "msg";
    /**
     * 结果处理是否成功，成功为T，失败为F
     */
    public static final String IS_SUCCESS_T = "T";
    public static final String IS_SUCCESS_F = "F";
    /**
     * 结果码
     */
    public static final String CODE = "code";
    /**
     * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss
     */
    public static final String NOTIFY_TIME = "notify_time";
    /**
     * 通知的类型
     */
    public static final String NOTIFY_TYPE = "notify_type";
    /**
     * 通知校验ID
     */
    public static final String NOTIFY_ID = "notify_id";
    /**
     * 交易目前所处的状态
     */
    public static final String TRADE_STATUS = "trade_status";
    /**
     * 交易创建，等待买家付款
     */
    public static final String TRADE_STATUS_WAIT = "WAIT_BUYER_PAY";
    /**
     * 未付款交易超时关闭，或支付完成后全额退款
     */
    public static final String TRADE_STATUS_CLOSED = "TRADE_CLOSED";
    /**
     * 交易支付成功
     */
    public static final String TRADE_STATUS_SUCCESS = "TRADE_SUCCESS";
    /**
     * 交易结束，不可退款
     */
    public static final String TRADE_STATUS_FINISHED = "TRADE_FINISHED";
    /**
     * 超时时间
     */
    public static final String TIMEOUT_EXPRESS = "timeout_express";
    public static final String TIMEOUT_EXPRESS_VALUE = "30m";

/**
 *
 * PC端即时支付参数
 *
 */

    /**
     * 支付宝账户登录授权业务：入参pid值  PARTNER
     */
    public static final String PARTNER = "partner";
    public static final String PARTNER_VLAUE = "20886218668700";
    /**
     * 收款支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
     */
    public static final String SELLER_ID = "seller_id";
    public static final String SELLER_ID_VALUE = "20886218678200";
    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static final String PCNOTIFY_URL_VALUE = "http://www.linglingwa.com/pay/notifyurl.do";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static final String RETURN_URL = "return_url";
    public static final String RETURN_URL_VALUE = "http://www.linglingwa.com/pay/returnurl.do";

    /**
     * 调试日志用log
     */
    public static final String LOG_PATH_VALUE = "E:\\workspace\\oow\\webapp\\resources\\paylog";
    /**
     * 支付类型
     */
    public static final String PAYMENT_TYPE = "payment_type";
    public static final String PAYMENT_TYPE_VALUE = "1";
    /**
     * 调用的接口名
     */
    public static final String SERVICE = "service";
    public static final String SERVICE_VALUE = "create_direct_pay_by_user";
    /**
     * 字符编码
     */
    public static final String _INPUT_CHARSET = "_input_charset";
    /**
     * 支付金额
     */
    public static final String TOTAL_FEE = "total_fee";
    //请求支付宝的参数
    public static final String PAYPARAM = "payparam";
    /**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    public static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    //↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
    public static final String anti_phishing_key = "";

    // 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
    public static final String exter_invoke_ip = "";


    //↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    //==================分割线=================

    // 单笔转账到支付宝参数
    // 单笔转账到支付宝账户接口

    /**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    public static final String ALIPAY_TRANSFER_HTTPS_URL = "https://openapi.alipay.com/gateway.do";
    /**
     * 商户转账唯一订单号。发起转账来源方定义的转账单据ID，不同商户订单号可以重复
     */
    public static final String OUT_BIZ_NO = "out_biz_no";
    /**
     * 收款方账户类型分为账号和 账户id2088开头
     */
    public static final String PAYEE_TYPE = "payee_type";
    public static final String PAYEE_TYPE_VALUE1 = "ALIPAY_USERID";
    public static final String PAYEE_TYPE_VALUE = "ALIPAY_LOGONID";


    public static final String METHOD_VALUE_TRANSFER = "alipay.fund.trans.toaccount.transfer";
    /**
     * 收款方账户
     */
    public static final String PAYEE_ACCOUNT = "payee_account";
    /**
     * 转账金额
     */
    public static final String AMOUNT = "amount";

    // 下列是可选参数
    /**
     * 付款方真实姓名
     */
    public static final String PAYER_REAL_NAME = "payer_real_name";
    /**
     * 收款方显示姓名
     */
    public static final String PAYER_SHOW_NAME = "payer_show_name";
    /**
     * 收款方真正姓名
     */
    public static final String PAYEE_REAL_NAME = "payee_real_name";
    /**
     * 转账备注
     */
    public static final String REMARK = "remark";
    /**
     * 扩展参数
     */
    public static final String EXT_PARAM = "ext_param";


    /**
     * 支付宝消息验证地址
     */
    public static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
    /**
     * 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
     */
    public static String log_path = "";


    // 查询转账订单接口
}
