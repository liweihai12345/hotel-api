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
public class MerchantBannerVO implements Serializable {
    private static final long serialVersionUID = 3049893080250302860L;
    private Integer id;
    private String title;//标题
    private String shortTitle;// 短标题描述
    private String content; // 描述
    private String htmlUrl; // 访问地址
    private Integer business;// 业务编号
    private Integer businessType;// 业务类型
    private Integer type;
    private Integer sort;
    private String word;
    private String imageUrl;

}
