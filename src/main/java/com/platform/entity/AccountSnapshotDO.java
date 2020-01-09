package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountSnapshotDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //总量
    private BigDecimal total;
    //总量记录
    private BigDecimal totalDetail;
    //普通邀请注册
    private BigDecimal regTotal;
    //运动
    private BigDecimal exTotal;
    //Done邀请注册
    private BigDecimal doneRegTotal;
    //购买
    private BigDecimal buyTotal;
    private BigDecimal userReg;
    private BigDecimal taskTotal;
    private BigDecimal extractTotal;
    private BigDecimal teamBack;
    //日期
    private String snapDate;
    //创建日期
    private Date createDate;

}
