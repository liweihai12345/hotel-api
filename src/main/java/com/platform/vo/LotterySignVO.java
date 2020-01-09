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
public class LotterySignVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; //主建
    private Long uid;//用户编号
    private String name;//
    private Integer status;// 状态0签到申请1签到成功
    private Date createDate;//
    private Date updateDate;//
    private BigDecimal spend;//

}
