package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 图片存储表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchantStoreVO implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Integer merchantId;
    private String merchantName;
    private String logo;
    private Integer proNumber;
    private Boolean focus;
    private String editing;
    private Integer funs;
    private List<MerchantBannerVO> banners;

    public String getDescribe() {
        return "在售商品" + proNumber + "件";
    }


}
