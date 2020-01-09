package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryWagerStaticsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String levelname;//等级名称
    private String number;// 中奖励数量
        private BigDecimal price;//奖品价值

}
