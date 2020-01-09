package com.platform.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import com.platform.util.enums.CoinTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * spc明细
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeCoinVVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long uid;
    private String phone;
    private BigDecimal sportCoin;
    private Long inviteUid;
    private String invitePhone;
    private Integer type;
    private String typeStr;
    private String image;
    private Date createdDate;

}
