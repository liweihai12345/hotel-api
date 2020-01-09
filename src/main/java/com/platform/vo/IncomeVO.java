package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String business;//营业收入
    private String room;//房费收入
    private String dinner;//餐饮收入
    private String product;//商品收入
    private String other;//其他收入
    private String total;//总收入

}
