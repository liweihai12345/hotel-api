package com.platform.dto;

import com.platform.util.BigDecimalUtil;
import com.platform.util.enums.CoinTypeEnum;
import com.platform.util.enums.EnergyCoinTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class IncomeCoinDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
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
    private Integer parentTeamId;

    public static final BinaryOperator<IncomeCoinDTO> convert = (o1, o2) -> {
        o1.setEnergyCoin(BigDecimalUtil.add(o1.getEnergyCoin(), o2.getEnergyCoin()));
        o1.setIncomeType(0);
        o1.setTypeName(CoinTypeEnum.ENERGY_TEAM_RUN.getValue());
        o1.setType(CoinTypeEnum.ENERGY_TEAM_RUN.getKey());
        return o1;
    };
}
