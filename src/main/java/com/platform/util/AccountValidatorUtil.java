package com.platform.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.platform.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 账户相关属性验证工具
 */
@Slf4j
public class AccountValidatorUtil {
    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,20}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    /**
     * 正则表达式：验证特殊富豪表情
     */
    public static final String REGEX_EMOJI = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    public static String replaceEmoji(String str) {
        Pattern pattern = Pattern.compile(REGEX_EMOJI);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String name = str.replaceAll(REGEX_EMOJI, "");
            if (StringUtils.isEmpty(name))
                return DateUtils.format(new Date(), "YYMMddHHmm");
            else return name;
        } else {
            return str;
        }

    }

    public static boolean checkTimeOut(HttpServletRequest request,long times) {

        String timestamp = request.getHeader("timestamp");
        long time = Long.valueOf(timestamp) + times;
        long currenttime = System.currentTimeMillis();
        if (time < currenttime) {
            return false;
        }
        return true;
    }
    public static boolean checkRequestHeader(HttpServletRequest request) {
        String access_token = request.getHeader("access_token");
        String timestamp = request.getHeader("timestamp");
        String uid = request.getHeader("uid");
        if (StringUtils.isEmpty(access_token) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(uid)) {
            return false;
        }
        return true;
    }
    public static boolean checkAppRequestHeader(HttpServletRequest request) {
        String access_token = request.getHeader("access_token");
        String timestamp = request.getHeader("timestamp");
        if (StringUtils.isEmpty(access_token) || StringUtils.isEmpty(timestamp) ) {
            return false;
        }
        return true;
    }


    public static boolean checkRequestSign(HttpServletRequest request,int type) {

        String access_token = request.getHeader("access_token");
        String timestamp = request.getHeader("timestamp");
        String uid = request.getHeader("uid");
        String content = Constants.getAccessToken(type) + timestamp + uid;
        try {
            return AlipaySignature.rsaCheck(content, access_token, Constants.PUBLIC_KEY, "utf-8", "RSA");
        } catch (AlipayApiException e) {
            return false;
        }
    }
//    public static void main(String[] args) {
//        System.out.println(replaceEmoji("\\xF0\\x9F\\x98\\xA3"));
//    }

}

