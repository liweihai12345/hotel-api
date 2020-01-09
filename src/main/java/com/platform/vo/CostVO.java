package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 成本费用月概况
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CostVO implements Serializable {

    private static final long serialVersionUID = -3955859850594777760L;

    private String consumable;//易耗品
    private String breakfast;//早餐
    private String labor;//人工工资
    private String paid;//有偿物品
    private String wash;//月洗涤
    private String commission;//平台佣金
    private String tax;//月税金

}
