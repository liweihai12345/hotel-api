package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/18 15:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestRoomListVO {
    private String rentRate;
    private String nightRentRoom;
    private String usableRoom;
    private String createDate;
}
