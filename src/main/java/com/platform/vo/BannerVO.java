package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * banner信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerVO implements Serializable {
    private static final long serialVersionUID = 3049893080250302860L;
    private Integer id; // banner编号
    private Integer type ; // banner类型类型1首页
    private String imageUrl; // 访问地址
    private Integer business;// 业务编号
    private Integer businessType;// 业务类型
    private Integer sort;//排序
    private String title;//标题

}
