package com.platform.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*4.2SPC*/


/**
 * 新版SPC
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnergySpcDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long uid;
    private String phone;
    private BigDecimal energyCoin;
    private Long inviteUid;
    private String invitePhone;
    private Integer type;
    private String typeName;
    private Integer incomeType;
    private String image;
    private Date createDate;
}
