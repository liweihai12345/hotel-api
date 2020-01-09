package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCommentDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo ;
    private Long userId ;
    private String userName ;
    private String logo ;
    private Integer proId ;
    private String proName;
    private String  proUrl;
    private Integer  styleId;
    private String styleName;
    private String styleUrl;
    private Integer number;
    private BigDecimal price;
    private String description;
    private String commentImg;
    private String content;
    private Integer statu;
    private Date createDate;
}
