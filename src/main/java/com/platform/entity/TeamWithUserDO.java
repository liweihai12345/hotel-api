package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamWithUserDO {
    private Long userId;
    private Integer parentTeamId;
    private Integer subTeamId;
    private Date createDate;
}
