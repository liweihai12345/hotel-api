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
 * @Description:社区分类
 * @Author: liweihai
 * @Date: Created in 2019/3/9 11:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommCateVO implements Serializable{
    private static final long serialVersionUID = 8839893529484346264L;
    private Integer id;
    private String name;
    private Integer sort;

}
