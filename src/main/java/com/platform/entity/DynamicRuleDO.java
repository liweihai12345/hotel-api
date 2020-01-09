package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:39
 */
public class DynamicRuleDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //规则类型0邀请好友1分享2每日签到3行走4发帖5评论
    private Integer type;
    //额外奖励
    private BigDecimal creditmoney;
    //获取spc
    private BigDecimal creditcount;
    //状态
    private Integer enabled;
    //创建日期
    private Date createdat;
    //更新日期
    private Date updatedat;
    //大类0邀请任务1每日任务
    private Integer category;
    //限制次数
    private Integer limitnum;
    //规则名称
    private String name;

    private String subtitle;

    private String finishname;
    //编码
    private String keycode;
    //是否完成
    private Integer isfinish;
    //完成次数
    private Integer finishnum;

    private Integer enable;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getFinishname() {
        return finishname;
    }

    public void setFinishname(String finishname) {
        this.finishname = finishname;
    }

    public Integer getFinishnum() {
        return finishnum;
    }

    public void setFinishnum(Integer finishnum) {
        this.finishnum = finishnum;
    }

    public Integer getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(Integer isfinish) {
        this.isfinish = isfinish;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
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
     * 设置：规则类型0邀请好友1分享2每日签到3行走4发帖5评论
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：规则类型0邀请好友1分享2每日签到3行走4发帖5评论
     */
    public Integer getType() {
        return type;
    }
    /**
     * 设置：消费金额
     */
    public void setCreditmoney(BigDecimal creditmoney) {
        this.creditmoney = creditmoney;
    }

    /**
     * 获取：消费金额
     */
    public BigDecimal getCreditmoney() {
        return creditmoney;
    }
    /**
     * 设置：获取积分
     */
    public void setCreditcount(BigDecimal creditcount) {
        this.creditcount = creditcount;
    }

    /**
     * 获取：获取积分
     */
    public BigDecimal getCreditcount() {
        return creditcount;
    }
    /**
     * 设置：状态
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取：状态
     */
    public Integer getEnabled() {
        return enabled;
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
    /**
     * 设置：大类0邀请任务1每日任务
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取：大类0邀请任务1每日任务
     */
    public Integer getCategory() {
        return category;
    }
    /**
     * 设置：限制次数
     */
    public void setLimitnum(Integer limitnum) {
        this.limitnum = limitnum;
    }

    /**
     * 获取：限制次数
     */
    public Integer getLimitnum() {
        return limitnum;
    }
    /**
     * 设置：规则名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：规则名称
     */
    public String getName() {
        return name;
    }
}
