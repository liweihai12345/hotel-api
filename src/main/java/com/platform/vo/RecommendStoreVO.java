package com.platform.vo;


import com.alipay.api.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * banner信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendStoreVO implements Serializable {
    private static final long serialVersionUID = 1L;



    private Integer mid;
    private String mname;
    private String logo;
    private Integer proNum;
    private Integer funs;
    private Boolean isFocus;
    private List<RecommendProductVO> products;

}
