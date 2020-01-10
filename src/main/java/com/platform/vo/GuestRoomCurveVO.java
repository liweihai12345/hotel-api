package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 产品表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestRoomCurveVO implements Serializable {
    private static final long serialVersionUID = -6292653839513119652L;
    private Integer id; // 商品ID


}
