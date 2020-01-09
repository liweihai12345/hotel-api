package com.platform.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlackListDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long uid;
    @ApiModelProperty(value = "用户编号")
    @NonNull
    private Long blackUid;
    private String blackName;
    private String blackLogo;
    private Date createDate;


}
