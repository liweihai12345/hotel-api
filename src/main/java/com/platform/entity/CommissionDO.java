package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommissionDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String keycode;
    private BigDecimal value;
    private String bakname;
    private Integer rule;
    private String createdDate;
    private Date updatedDate;

}
