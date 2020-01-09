package com.platform.api;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.platform.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/9 13:19
 */
@Controller
//@RequestMapping("/kaptcha")
public class KaptchaController {
    @Autowired
    private Producer producer;
    @Autowired
    private RedisUtil redisUtil;

    //@RequestMapping("/image")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //this.getLocalIp(request);
        String sdd = request.getRemoteAddr();
        //log.info("request.getRemoteAddr():{}",sdd);
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        redisUtil.set(Constants.KAPTCHA_SESSION_KEY + text, text, 120);


        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    public String getLocalIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");
//        log.info("forwarded:{}",forwarded);
//        log.info("realIp:{}",realIp);
        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = remoteAddr + "/" + forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                if (forwarded != null) {
                    forwarded = forwarded.split(",")[0];
                }
                ip = realIp + "/" + forwarded;
            }
        }
        return ip;
    }

}
