package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:39
 */
public class TaskIncomeDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //积分配置规则id
    private Integer creditruleid;
    //获取描述
    private String name;
    //所得积分
    private BigDecimal integral;
    //类型0获取1消费
    private Integer type;
    //创建日期
    private Date createdat;
    //更新日期
    private Date updatedat;
    //用户id
    private Long userid;
    //用户姓名
    private String username;

    private Integer enable;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
     * 设置：积分配置规则id
     */
    public void setCreditruleid(Integer creditruleid) {
        this.creditruleid = creditruleid;
    }

    /**
     * 获取：积分配置规则id
     */
    public Integer getCreditruleid() {
        return creditruleid;
    }
    /**
     * 设置：获取描述
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：获取描述
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：所得积分
     */
    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    /**
     * 获取：所得积分
     */
    public BigDecimal getIntegral() {
        return integral;
    }
    /**
     * 设置：类型0获取1消费
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：类型0获取1消费
     */
    public Integer getType() {
        return type;
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
