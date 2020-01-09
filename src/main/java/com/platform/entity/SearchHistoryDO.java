package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:41
 */
public class SearchHistoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //关键字
    private String keyword;
    //搜索来源，如PC、小程序、APP等
    private String from;
    //搜索时间
    private Date createDate;
    //会员Id
    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
