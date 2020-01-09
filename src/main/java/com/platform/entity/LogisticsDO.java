package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogisticsDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //物流名称
    private String name;
    private String logisticsNo;
    //定单编号
    private String orderno;
    //状态
    private Integer statu;
    //产品编号
    private Integer pid;
    //产品名称
    private String pname;
    //数量
    private Integer num;
    //编码
    private String code;
    //用户编号
    private Long userId;
    //用户名
    private String userName;
    //手机
    private String phone;
    //
    private Date createDate;
    //
    private Date updateDate;

    private int type;

    private String receiveUser;

    private Date orderDate;

    private String remark;
}
