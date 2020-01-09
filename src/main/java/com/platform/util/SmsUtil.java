package com.platform.util;

import com.platform.entity.SmsTemplateDO;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class SmsUtil {
    /**
     * 发送短信并返回发送成功标识
     *
     * @param mobile     手机号
     * @param randomCode 6位验证码
     * @return true表示发送成功 false表示发送失败
     */
    public static boolean sendMsgCloud(String mobile, String randomCode, SmsTemplateDO temp) {
        if(temp== null){
            return true;
        }
        String content = convert(temp, randomCode);
        String response = null;
        try {
            HttpRequestUtil httputil = new HttpRequestUtil();
            StringBuilder param = new StringBuilder();
            String url = "http://47.110.81.61:18002/send.do";
            String ecodeContent = URLEncoder.encode(content, "UTF-8");
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String password = MD5Util.MD5Encode("746603" + dateTime, "utf-8");
            param.append("uid=2145");
            param.append("&pw=").append(password);
            param.append("&mb=").append(mobile);
            param.append("&ms=").append(ecodeContent);
            param.append("&tm=").append(dateTime);
            //调用post发送方式发送短信到企信通短信平台
            //测试关掉
            response = httputil.sendPost(url, param.toString());
            return true;
        } catch (Exception e) {
            log.error("发送结果异常:", response);
        }
        log.info("发送返回结果:", response);
        String errorCode = response.substring(0, 1);
        if ("-".equals(errorCode)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 随机生成6位密码
     *
     * @return
     */
    public static String getRandomCode() {
        Random random = new Random();
        String x = random.nextInt(899999) + "";
        if (x.length() < 6) {
            for (int i = x.length(); i < 6; i++) {
                x += "0";
            }
        }
        return x;
    }

    //变量匹配
    private static Pattern PARAM_PATTERN = Pattern.compile("\\$\\{(.*?)\\}");
    private static Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    public static String convert(SmsTemplateDO temp, String code) {

        String template = temp.getContent();
        while (template.contains("${")) {
            Matcher matcher = PARAM_PATTERN.matcher(template);
            if (matcher.find()) {
                String ele = "code";
                template = template.replaceFirst("\\$\\{" + ele + "\\}", code);
            }
        }
        log.info(template);
        return template;
    }
    //替换字符
    public static String replaceStr(String template, String code) {

        while (template.contains("{")) {
            Matcher matcher = PATTERN.matcher(template);
            if (matcher.find()) {
                String ele = "code";
                template = template.replaceFirst("\\{" + ele + "\\}", code);
            }
        }
        return template;
    }



}
