package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @Description:个人盈亏净利-柱状
 * @Author: liweihai
 * @Date: Created in 2019/1/9 12:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetIncomePrismaticVO implements Serializable {


    private static final long serialVersionUID = -5621258841150577017L;
    private int i;
}
