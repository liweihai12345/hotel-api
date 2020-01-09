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
public class DynamicVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String newdes;
    private Long uid;
    private String name;
    private String logo;
    private String imageUrl;
    private Integer praise;
    private Integer collect;
    private Boolean isCollect;
    private Boolean click;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String location;
    private Integer comments;
    private Integer type;
    @ApiModelProperty(value = "0互相否1我VS你2你VS我3互相")
    private Integer focus;//关注
    private List<String> imgs ;
    private List<DynamicCommentVO> list;
    private List<UserDynamicPictureDO> pictures;
    private Date createDate;


}
