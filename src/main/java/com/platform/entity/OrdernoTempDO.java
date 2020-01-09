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
public class OrdernoTempDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tempNo;
    private String ordernoStr;
    private Long userId;
    private Integer isPay;
    private Date createDate;

}
