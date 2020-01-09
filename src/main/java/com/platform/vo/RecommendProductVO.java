package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * banner信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendProductVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pid;
    private String picture;
    private String pname;
    private BigDecimal price;
}
