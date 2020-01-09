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
 * 产品表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionProductDetailVO implements Serializable {
    private static final long serialVersionUID = 8552811650257936707L;
    private Integer id; // 商品ID
    private String name; // 产品名称
    private String banners; // 产品名称
    private String productUrl; // 图片地址
    private BigDecimal price; // 商品价格
    private BigDecimal oldPrice; // 商品价格
    private Integer spcPrice; // 商品价格
    private Integer type; // 商品价格
    private String describ; // 描述
    private String image; // 图片
    private String content;//内容新
    private List<ProductStyleVO> styles;
    private String payWay;
    private Integer aid;
    //押金
    private Integer deposit;
    //报名时间
    private Date enrollStart;
    //报名结束时间
    private Date enrollEnd;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //起拍价
    private Integer basePrice;
    //封顶价
    private Integer cappedPrice;
    //增长倍数
    private BigDecimal multiple;
    private Integer merchantId;
    private String merchantName;
    public List<String> getBannerList() {
        if (StringUtils.isEmpty(this.banners)) {
            return new ArrayList<>();
        }
        String[] arr = this.banners.split(",");
        List<String> list = Arrays.asList(arr);
        return list;
    }

}
