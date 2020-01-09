package com.platform.vo;

import com.platform.entity.UserDynamicPictureDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 动态
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendDynamicVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String newdes;
    private String image ;
    private Integer type ;

}
