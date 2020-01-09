package com.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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
public class SportShareVO {
    private Long uid;
    private String name;
    @ApiModelProperty("今日运动距离")
    private BigDecimal distance;
    @ApiModelProperty("今日运动时长")
    private Integer timeLen;
    @ApiModelProperty("消耗卡路里")
    private BigDecimal calorie;
    @ApiModelProperty("今日收益")
    private BigDecimal income;
    @ApiModelProperty("一款运动就赚钱的APP")
    private String desc;
    @ApiModelProperty("背景图")
    private String bgimg;

}
