package com.platform.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

/*能量值*/

import java.io.Serializable;
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
public class EnergyCoinDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long uid;
    private String phone;
    private BigDecimal energyCoin;
    private BigDecimal distance;
    private Long inviteUid;
    private String invitePhone;
    private Integer type;
    private String typeName;
    private Integer incomeType;
    private String image;
    private Date createDate;
}
