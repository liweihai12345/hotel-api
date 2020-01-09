package com.platform.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.platform.util.BigDecimalUtil;
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
 * @Date: Created in 2019/1/18 15:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnergyTaskVO {

    private Integer id;
    private Integer type;
    private BigDecimal value;//奖励值
    private String valueStr;
    private Integer category;// 周期
    private Integer limitnum;//次数
    private String name;//名称
    private String title; //任务状态
    private String keycode; //任务状态
    private String finishname;
    private boolean status;

    public String getFinishname() {
        if (status) {
            return "已完成";
        }
        return finishname;
    }
    public String getValueStr() {
        BigDecimal temp = BigDecimalUtil.format(value, 2);
        return "x" + temp +"%";
    }
    public BigDecimal getValue(){
        return BigDecimalUtil.format(value,2);
    }

}
