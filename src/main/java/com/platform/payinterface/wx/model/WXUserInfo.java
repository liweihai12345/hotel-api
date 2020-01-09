package com.platform.payinterface.wx.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/3/5 18:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WXUserInfo {
    private String country;
    private String province;
    private String city;
    private String unionid;
    private String openid;
    private Integer sex;
    private String nickname;
    private String headimgurl;
}
