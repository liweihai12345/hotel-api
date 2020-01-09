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
public class LotteryRecordDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Long uid;
    private String phone;
    private Integer lotteryId;
    private String lotteryName;
    private Integer level;
    private String levelName;
    private Integer type;
    private BigDecimal price;
    private BigDecimal spend;
    private Date createDate;

}
