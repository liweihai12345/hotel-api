package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 动态
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCateDTO implements Serializable {

    private static final long serialVersionUID = 4577832207334162112L;
    private Integer cateId;
    private String cateName;
    private BigDecimal rate;
}
