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
public class ExtractCoinDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long userId;
    private String phone;
    private String userName;
    private Integer type;
    private BigDecimal number;
    private Date createDate;

}
