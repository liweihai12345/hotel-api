package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author
 * @email 订单产品类
 * @date 2017-08-15 08:03:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String orderNo;
    private Integer productId;
    private String productName;
    private String productUrl;
    private String description;
    private Integer styleId;
    private String styleName;
    private String styleUrl;
    private String dimensions;
    private BigDecimal price;
    private Integer spcPrice;
    private Integer type;
    private Integer number;
    private Date createDate;

}
