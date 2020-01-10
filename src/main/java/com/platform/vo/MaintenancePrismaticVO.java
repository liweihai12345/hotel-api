package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @Description:维护基金 柱状图
 * @Author: liweihai
 * @Date: Created in 2019/1/20 20:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenancePrismaticVO implements Serializable {

    private static final long serialVersionUID = -6106014513801528881L;

    private int i;
}
