package com.platform.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @Description:财务曲线图
 * @Author: liweihai
 * @Date: Created in 2019/1/17 14:01
 */
@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinanceCurveVO implements Serializable {

    private static final long serialVersionUID = -8298184996407360516L;
    private int i;

}
