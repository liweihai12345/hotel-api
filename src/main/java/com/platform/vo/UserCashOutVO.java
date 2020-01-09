package com.platform.vo;

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
public class UserCashOutVO {
    private Long id;
    private String cashNo;
    private String cardNo;
    private String cardBank;
    private String openBank;
    private BigDecimal amount;
    private Date createDate;
    private Date finishDate;
    private Integer status;
    private String remark;
}
