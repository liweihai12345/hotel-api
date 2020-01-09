package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 商城_用户级别
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String business;//营业
    private String room;//房费
    private String dinner;//餐饮
    private String product;//商品
    private String other;//其他
    private String createdDate;//日期


}
