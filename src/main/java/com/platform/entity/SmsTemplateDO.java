package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_sms_template
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-21 00:36:13
 */
public class SmsTemplateDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //模板名称
    private String name;
    //类型
    private Integer type;
    //短信正文
    private String content;
    //发送状态
    private Integer status;
    //创建日期
    private Date createdat;
    //更新日期
    private Date updatedat;
    //模板id
    private Integer templateid;
    // 是否同步
    private Integer  issynch;

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public Integer getIssynch() {
        return issynch;
    }

    public void setIssynch(Integer issynch) {
        this.issynch = issynch;
    }

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
     * 设置：模板名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：模板名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：类型
     */
    public Integer getType() {
        return type;
    }
    /**
     * 设置：短信正文
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：短信正文
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：发送状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：发送状态
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：创建日期
     */
    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    /**
     * 获取：创建日期
     */
    public Date getCreatedat() {
        return createdat;
    }
    /**
     * 设置：更新日期
     */
    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    /**
     * 获取：更新日期
     */
    public Date getUpdatedat() {
        return updatedat;
    }
}
