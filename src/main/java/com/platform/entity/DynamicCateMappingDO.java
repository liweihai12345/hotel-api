package com.platform.entity;

import java.io.Serializable;


public class DynamicCateMappingDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private Integer categoryid;
    //
    private Long newsid;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * 获取：
     */
    public Integer getCategoryid() {
        return categoryid;
    }
    /**
     * 设置：
     */
    public void setNewsid(Long newsid) {
        this.newsid = newsid;
    }

    /**
     * 获取：
     */
    public Long getNewsid() {
        return newsid;
    }
}
