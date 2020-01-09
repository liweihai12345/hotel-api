package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long userId;
    private String name;
    private Integer type;
    private String idCardNo;
    private String frontImg;
    private String reverseImg;
    private String expiryDate;
    private Date createDate;
    private Integer statu;

}
