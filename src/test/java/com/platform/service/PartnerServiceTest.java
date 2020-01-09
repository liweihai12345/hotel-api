package com.platform.service;

import com.alibaba.fastjson.JSONObject;
import com.platform.payinterface.wx.model.WXUserInfo;
import com.platform.util.AccountValidatorUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/3/8 13:23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PartnerServiceTest {
    @Autowired
    PartnerService partnerService;

    @Test
    public void addPartner() {
        String result = "{\n" +
                "\"openid\": \"oOPdB5lJHcs2JI38eYtwVR0Qkzic\",\n" +
                "\"nickname\": \"墨。璃心\uD83D\uDC25\",\n" +
                "\"sex\": 2,\n" +
                "\"language\": \"zh_CN\",\n" +
                "\"city\": \"吉林\",\n" +
                "\"province\": \"吉林\",\n" +
                "\"country\": \"中国\",\n" +
                "\"headimgurl\": \"http:\\/\\/thirdwx.qlogo.cn\\/mmopen\\/vi_32\\/Q0j4TwGTfTJFnr0mrblTKuqYMoXZ8TuVLADJLvjunoSN07jALwsxMYKfZ7gUv3mA1yVnRPltbsJA2ehAyia1hLg\\/132\",\n" +
                "\"privilege\": [],\n" +
                "\"unionid\": \"oFaEe08widEC8wF9LN8LDgRtIJao\"\n" +
                "}";
        result = AccountValidatorUtil.replaceEmoji(result);
        JSONObject json = JSONObject.parseObject(result);
        WXUserInfo info = JSONObject.toJavaObject(json, WXUserInfo.class);
//        partnerService.addPartner("12345", info.getOpenid(), info.getNickname(), info.getHeadimgurl(), info.getSex(),null);
//        partnerService.addPartner( mobile,  inviteId,  openid, nickName, gender, logo,  deviceToken);
    }
}