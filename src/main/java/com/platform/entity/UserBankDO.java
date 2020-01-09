package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 13:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBankDO {
    private Long id;
    private Long uid;
    private String phone;
    private String cardNo;
    private String cardBank;
    private String openBank;
    private String realName;
    private String idCardNo;
    private String idCardType;
    private String reservePhone;
    private Date createDate;
    private Date updateDate;
}
