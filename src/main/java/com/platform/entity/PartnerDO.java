package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 合伙人信息表
 *
 * @author wolf
 * @Date 2018年12月3日 上午10:04:20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDO implements Serializable {

    private static final long serialVersionUID = -5416286708432554727L;
    private Long id;//合伙人编号
    private String name;//昵称
    private String realName;//真实姓名
    private String mobile;//手机号
    private String password;//登录密码
    private String pictureUrl;//头像地址
    private Integer status;//状态 ：0关闭1启用
    private Date createTime;//注册时间
    private Integer gender;//性别（0男  1女）
    private String birthDate;//出生日期（yyyy-MM-dd）
    private String address;//所在城市
    private String signature;//个性签名
    private String wxUnionId;//微信联合编号
    private String payPassword;//支付密码
    private String iscollect;//是否关注
    private Integer isDone;//
    private boolean invite;//
    private String bgimg;//用户背景图片
    private Integer iscollectme;  //是否关注我
    private Integer iscollectother;    //是否关注他
    private String deviceTokens;    //设备标识
    private Integer deviceType;    //设备标识
    private Integer danger;    //风险级别0正常
    private Integer level;    //奖励级别1倍3倍6倍10倍
    private Integer version;    //奖励级别1倍3倍6倍10倍
}
