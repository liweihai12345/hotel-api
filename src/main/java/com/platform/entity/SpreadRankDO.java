package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 推广排行榜
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpreadRankDO implements Serializable{
	private static final long serialVersionUID = 6078235171805242909L;
	
	private Integer id; // 排名ID
	private Long userId;
	private String userName;
	private String userLogo;
	private String phone;
	private Integer ranking;
	private Integer teamId; 
	private Date updateTime;
	private Integer teamCount;
	private String teamName;
    private String monthDate;

}
