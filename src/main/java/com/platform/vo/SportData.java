package com.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * @Date: Created in 2019/1/17 14:01
 */
@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportData {
    @ApiModelProperty("今日运动距离")
    private BigDecimal distance;
    @ApiModelProperty("今日运动时长")
    private Integer timeLen;
    @ApiModelProperty("消耗卡路里")
    private BigDecimal calorie;
    private Date createDate;
}
