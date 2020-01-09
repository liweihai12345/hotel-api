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
public class MyLotteryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lotteryname;//奖品级别
    private String redball;
    private String currentstageredball;
    private BigDecimal price;//奖品级别
    private BigDecimal cost;//总价
    private Integer num;//注数
    private String stages;//注数
    private Date createDate;//购买时间
    private Integer exchange;
    private BigDecimal bonus;

}
