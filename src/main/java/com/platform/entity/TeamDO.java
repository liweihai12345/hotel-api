package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 团队信息表
 * 
 * @author wolf
 * @Date 2018年12月3日 上午9:55:29
 */
public class TeamDO implements Serializable {
	private static final long serialVersionUID = -6958502979452401684L;
	
	private Integer id;// 编号
	private String name;// 团队名称
	private Date createTime; // 创建时间
	private Boolean type; 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Boolean getType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	
}
