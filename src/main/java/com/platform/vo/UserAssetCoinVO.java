package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
public class UserAssetCoinVO implements Serializable {

    private static final long serialVersionUID = -6106014513801528881L;
    private List<IncomeListVO> list;// 列表
    private BigDecimal coin;// 总链
    private BigDecimal coinFrozen;// 总冻结链
    private BigDecimal spcCoin;// 总链
    private BigDecimal spcCoinFrozen;// 总冻结链
    private BigDecimal currency; //今日已收
    private BigDecimal reap; // 今日代收


}
