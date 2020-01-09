package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 搜索用户对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {

    private static final long serialVersionUID = -5416286708432554727L;
    private Long id;//合伙人编号
    private String name;//昵称
    private String mobile;//手机号
    private String pictureUrl;//头像地址
    private Integer focus;
    private String signature;//个性签名


}
