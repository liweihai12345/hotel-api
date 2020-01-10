package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 营收饼状图
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomePieVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer count;

}
