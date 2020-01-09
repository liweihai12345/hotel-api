package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDrawbackDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo;
    private Long uid;
    private String phone;
    private Integer proId;
    private Integer proStatus;
    private String proStatusName;
    private BigDecimal amount;
    private BigDecimal backAmount;
    private String cause;
    private String explain;
    private String certificate;
    private Integer statu;
    private BigDecimal giveEnergy;
    private BigDecimal spcFree;
    private BigDecimal giveTeam;
    private Date createDate;
    private Date updateDate;
    private Date finishDate;


}
