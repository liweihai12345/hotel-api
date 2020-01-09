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
public class MerchantInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;
    private Long userId;
    private String name;
    private String logo;
    private String institution;
    private String statu;
    private BigDecimal amount;
    private BigDecimal frozen;
    private Integer productNum;
    private String editing;
    private Integer funs;
    private Date createDate;


}
