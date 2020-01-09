package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;//用户ID
    private String nickName;//昵称
    private String mobile;//手机号
    private String pictureUrl;//头像地址
    private Integer gender;//性别（0男  1女）
    private Integer age;//年龄
    private String signature;//个性签名
    private String bgimg;//用户背景图片
    private String amount;//可用
    private String totalAmount;//总收益
    private String inviteAmount;//邀请收益

}
