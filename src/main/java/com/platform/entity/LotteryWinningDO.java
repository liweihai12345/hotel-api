package com.platform.entity;

import com.platform.vo.LotteryWagerStaticsVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryWinningDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String redBall;
    private Integer blueBall;
    private Integer status;
    private Integer type;
    private String stages;
    private String openDateStr;
    private Date createDate;
    private Date openDate;
    private String text;

    private List<LotteryWagerStaticsVO> lotteryWagerStatics;

}
