package com.platform.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 动态
 */
@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderParamDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
    private Integer aid;
    private Integer pay_way;
    private Integer blend;
    private List<OrderProParamDTO> list;

}
