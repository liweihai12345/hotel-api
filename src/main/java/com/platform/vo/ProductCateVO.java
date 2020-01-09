package com.platform.vo;

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
 * @Date: Created in 2019/1/28 15:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCateVO {
    private Integer id;
    private String name;
    private Integer parentId;
    private String imageUrl;
    private Integer sortOrder;
    private BigDecimal energyRate; //赠送能量利率
    private BigDecimal spcFree; //释放能量费率
    private List<ProductCateVO> child;
}
