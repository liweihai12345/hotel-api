package com.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program:
 * @Description:社区（首页）
 * @Author: liweihai
 * @Date: Created in 2019/3/9 11:58
 */
@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AusleseVO implements Serializable{
    private static final long serialVersionUID = 45386315865413310L;
    private Long bid;
    private Long uid;
    private String nickName;
    private String logo;
    private String content;
    private Integer comments;//评论
    @ApiModelProperty(value = "0互相否1我VS你2你VS我3互相")
    private Integer focus;//关注
    private Integer praise;//点赞
    private Boolean click;//点赞
    private List<String> imgs ;
    private Integer sort;//排序

}
