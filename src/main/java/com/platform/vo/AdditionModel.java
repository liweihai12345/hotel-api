package com.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 合伙人级别信息
 */
@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdditionModel implements Serializable {
    private static final long serialVersionUID = -7832350897071483917L;
    @ApiModelProperty(value = "")
    private Long id;
    @ApiModelProperty(value = "token")
    private String token;
    @ApiModelProperty(value = "昵称")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "团队编号")
    private Integer teamId;
    @ApiModelProperty(value = "团队名称")
    private String teamName;
    @ApiModelProperty(value = "团队编号")
    private Integer parentTeamId;
    //团队总人数
    private Integer teamCount;
    @ApiModelProperty(value = "头像")
    private String pictureUrl;
    @ApiModelProperty(value = "运动链数")
    private String sportsChain;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "出生日期")
    private String birthDate;
    @ApiModelProperty(value = "所在城市")
    private String address;
    @ApiModelProperty(value = "个性签名")
    private String signature;
    @ApiModelProperty(value = "金额")
    private String balance;
    @ApiModelProperty(value = "实名认证 0未认证 1正在认证 2成功 3失败")
    private Integer realNameFlag;
    @ApiModelProperty(value = "是否设置有支付密码")
    private boolean payFlag;
    @ApiModelProperty(value = "是否是DONE")
    private boolean isDone;
    @ApiModelProperty(value = "是否绑定微信")
    private boolean wxFlag;
    //平台总人数
    private Integer totalCount;
    private Integer vip;
    @ApiModelProperty(value = "spc数量")
    private String spcCoin;
    @ApiModelProperty(value = "spc冻结数量")
    private String spcCoinFrozen;
    @ApiModelProperty(value = "冻结能量")
    private String coinFrozen;


}
