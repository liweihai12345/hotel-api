package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description: 昨日概况
 * @Author: liweihai
 * @Date: Created in 2019/3/6 13:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestRoomVO {
    private static final long serialVersionUID = -1048383089042654389L;
    private int totalRoom;//总房间
    private int usableRoom;//可出租
    private int nightRentRoom;//已售房间夜
    private int totalAmount;//总额
    private int netIncome;//净额
    private int rentRate;//出租率

}
