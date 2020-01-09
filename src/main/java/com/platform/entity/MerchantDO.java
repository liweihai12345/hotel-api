package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 代理商表实体
 * 表名 merchant
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-24 16:26:25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //平台用户编号
    private Long userId;
    //平台用户手机
    private String ddPhone;
    //商户姓名
    private String realname;
    //商户名称
    private String name;
    //商户手机号
    private String phone;
    //身份证号
    private String idcard;
    //身份证正面
    private String value;
    //身份证反面
    private String value1;
    //售卖商品简述
    private String institution;
    //商户地址
    private String address;
    //商户资质
    private String license;
    //开户许可
    private String openLicence;
    //开户银行
    private String value2;
    //开户支行
    private String value3;
    //银行账户
    private String value4;
    //开户银行城市
    private String value5;
    //状态0关闭1启用
    private Integer statu;
    //创建时间
    private Date createDate;
    //修改时间
    private Date updateDate;
}
