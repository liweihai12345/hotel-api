package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;
    private Long userid;
    private String userName;
    private String userPhone;
    private String  orderno;
    private BigDecimal ordermoney;
    private BigDecimal mymoney;
    private Integer status;
    private Integer type;
    private Integer protype;
    private Long consumId;
    private String consumName;
    private String consumPhone;
    private BigDecimal rate;
    private BigDecimal tariff;
    private Date createdDate;
    //更新日期
    private Date updatedDate;



}
