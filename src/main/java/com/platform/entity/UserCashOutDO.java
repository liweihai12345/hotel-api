package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 14:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCashOutDO {
    private Long id;
    private String cashNo;
    private Long uid;
    private String phone;
    private String idCardNo;
    private String cardNo;
    private String realName;
    private String cardBank;
    private String openBank;
    private BigDecimal amount;
    private String reservePhone;
    private Date createDate;
    private Date finishDate;
    private Integer status;
    private String remark;

}
