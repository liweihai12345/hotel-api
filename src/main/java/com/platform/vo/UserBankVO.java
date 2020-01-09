package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 14:50
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBankVO {

    private Long id;
    private Long uid;
    private String phone;
    private String cardNo;
    private String cardBank;
    private String openBank;
    private Date createDate;
    private Date updateDate;
}
