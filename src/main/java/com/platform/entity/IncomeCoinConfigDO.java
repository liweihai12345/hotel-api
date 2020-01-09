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
 * @date 2017-08-15 08:03:41
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeCoinConfigDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private BigDecimal value;
    private BigDecimal multiple;
    private String rule;
    private Integer status;
    private Integer type;
    private Boolean done;
    private BigDecimal maxLength;
    private BigDecimal maxNum;
    private BigDecimal num;
    private BigDecimal minNum;
    private Date createdDate;
}
