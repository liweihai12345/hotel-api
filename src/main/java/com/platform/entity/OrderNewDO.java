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
public class OrderNewDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String orderNo;
    private String trandNo;
    private Long userId;
    private String userName;
    private String userPhone;
    private BigDecimal amount;
    private BigDecimal realAmount;
    private Integer number;
    private Integer payWay;
    private Integer status;
    private Integer payStatus;
    private String receiveUser;
    private String receivePhone;
    private String address;
    private String provinceId;
    private String cityId;
    private String areaId;
    private Date payDate;
    private Date finishDate;
    private Date createDate;
    private Integer merchantId;
    private String merchantName;
    private Integer type;
    private BigDecimal rate;
    private BigDecimal rateValue;
    private String remark;

}
