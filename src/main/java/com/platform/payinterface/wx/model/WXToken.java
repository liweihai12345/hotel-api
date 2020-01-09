package com.platform.payinterface.wx.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/3/5 17:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WXToken {
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
}
