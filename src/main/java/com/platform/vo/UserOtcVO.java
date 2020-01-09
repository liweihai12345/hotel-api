package com.platform.vo;

import io.swagger.annotations.ApiModelProperty;
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
public class UserOtcVO implements Serializable {

    private static final long serialVersionUID = -5416286708432554727L;
    @ApiModelProperty(value = "编号")
    private Long id;
    @ApiModelProperty(value = "昵称")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "头像")
    private String pictureUrl;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "出生日期")
    private String birthDate;
    @ApiModelProperty(value = "所在城市")
    private String address;
    @ApiModelProperty(value = "个性签名")
    private String signature;
    @ApiModelProperty(value = "是否是DONE")
    private Integer isDone;



}
