package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long userId;
    private String mobile;
    private String postCode;
    private String contactName;
    private Integer provinceId;
    private String province;
    private Integer cityId;
    private String city;
    private Integer areaId;
    private String county;
    private String address;
    private String remark;
    private Boolean isDefault;


}
