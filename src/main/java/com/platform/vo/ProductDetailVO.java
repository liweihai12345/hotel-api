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
import java.util.List;

/**
 * 产品表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailVO implements Serializable {
    private static final long serialVersionUID = -6292653839513119652L;
    private Integer id; // 商品ID
    private String name; // 产品名称
    private String banners; // 产品名称
    private String productUrl; // 图片地址
    private BigDecimal price; // 商品价格
    private BigDecimal old_price; // 商品价格
    private Integer type; // 商品价格
    private String describ; // 描述
    private String image; // 图片
    private String body; // 内容
    private String content;//内容新
    private String other; // 其他
    private String other1; // 其他
    private int number; // 数量
    private List<ProductStyleVO> styles;
    private String payWay;
    private Integer merchantId;
    private String phone;
    private String merchantName;
    private String merchantLogo;//logo
    private Integer totalNum; //在售产品数量
    private String rate;
    private BigDecimal giveEnergyMul; //赠送能量倍数
    private BigDecimal spcFreeMul; //释放能量倍数
    private BigDecimal giveTeamMul; //团队倍数

    public List<String> getBannerList() {
        if (StringUtils.isEmpty(this.banners)) {
            return new ArrayList<>();
        }
        String[] arr = this.banners.split(",");
        List<String> list = Arrays.asList(arr);
        return list;
    }

}
