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
public class ProductCateMappingDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer productId;
    private Integer parentId;
    private Integer childId;

}
