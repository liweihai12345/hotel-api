package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/16 9:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegSnapshotVO {
    //平台总用户
    private  Integer  regTotal;
    //done用户
    private  Integer  doneTotal;
//    普通用户
    private  Integer  normalTotal;

    private  Integer  difference;

    private  String  snapDate;


}
