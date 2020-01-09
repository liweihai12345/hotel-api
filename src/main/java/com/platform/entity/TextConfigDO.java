package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 text_config
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-03-18 14:17:08
 */
public class TextConfigDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //编号
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //底部
    private String bottom;
    //类型1邀请2分享3闪兑
    private Integer type;
    //描述说明
    private String comment;
    private String htmlComment;
    //
    private Integer status;
    //创建时间
    private Date createDate;
    private String nodone;
    private String done;

    /**
     * 设置：编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置：底部
     */
    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getHtmlComment() {
        return htmlComment;
    }

    public void setHtmlComment(String htmlComment) {
        this.htmlComment = htmlComment;
    }

    /**
     * 获取：底部
     */
    public String getBottom() {
        return bottom;
    }

    /**
     * 设置：类型1邀请2分享3闪兑
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：类型1邀请2分享3闪兑
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置：描述说明
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取：描述说明
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置：
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    public String getNodone() {
        return nodone;
    }

    public void setNodone(String nodone) {
        this.nodone = nodone;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
