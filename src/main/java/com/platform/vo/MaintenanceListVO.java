package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @Description:维护基金列表
 * @Author: liweihai
 * @Date: Created in 2019/1/20 20:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceListVO implements Serializable {

    private static final long serialVersionUID = -6106014513801528881L;


    private String project;//项目
    private String type;//类型
    private String typeName;//类型名称
    private String amount;//金额
    private String createDate;//日期


}
