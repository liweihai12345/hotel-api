package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @Description:运动详情页
 * @Author: liweihai
 * @Date: Created in 2019/1/20 20:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAssetVO implements Serializable {

    private static final long serialVersionUID = -6106014513801528881L;

    //    private BigDecimal amount;
//    private BigDecimal frozen;
    private String coin;
    private String coinFrozen;
    private String coinIncome;
    private String spcCoinFrozen;
    private String spcCoin;
    private String spcIncome;
    private String backRate;


}
