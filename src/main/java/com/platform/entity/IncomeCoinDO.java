package com.platform.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import com.platform.util.BigDecimalUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BinaryOperator;


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
public class IncomeCoinDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String tradeNo;
    private Long uid;
    private String phone;
    private BigDecimal sportCoin;
    private BigDecimal distance;
    private Long inviteUid;
    private String invitePhone;
    private String inviteName;
    private String inviteLogo;
    private Integer type;
    private Integer statu;
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createdDate;

}
