package com.platform.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
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
public class UserAssetDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long uid;
    private String phone;
    private String userName;
    private BigDecimal amount;
    private BigDecimal frozen;
    private BigDecimal coin;
    private BigDecimal coinFrozen;
    private BigDecimal kilometer;
    private BigDecimal kilometerExtra;
    private BigDecimal kilometerReal;
    private BigDecimal spcCoinFrozen;
    private BigDecimal spcCoin;
    private BigDecimal backRate;
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createDate;
    private Integer version;
    
}
