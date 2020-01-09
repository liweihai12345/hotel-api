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


/**
 * 商城_用户级别
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpcTransferDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long uid;
    private String phone;
    private String transNo;
    private BigDecimal coin;
    private BigDecimal rate;
    private BigDecimal rateValue;
    private Integer type;
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createdDate;

}
