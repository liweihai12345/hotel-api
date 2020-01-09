package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyTeamVO implements Serializable {
	private static final long serialVersionUID = -6958502979452401684L;
	private Integer id;// 编号
	private String name;// 团队名称
	private Date createTime; // 创建时间
	private Boolean type;
	private Integer  count;
	List<MyTeamUserVO> list;
    private String  parentPhone;

}
