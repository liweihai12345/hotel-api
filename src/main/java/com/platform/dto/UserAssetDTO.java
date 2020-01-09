package com.platform.dto;

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
public class UserAssetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long uid;
    private BigDecimal spcCoin;
    private Integer version;
    private Integer done;
}
