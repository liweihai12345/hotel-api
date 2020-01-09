package com.platform.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 官网商户加盟表实体
 * 表名 merchant_invite
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-04-02 18:12:09
 */
public class MerchantInviteDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //申请名称
    private String name;
    //申请电话
    private String phone;
    //所在城市
    private String address;

    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 设置：id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：id
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：申请名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：申请名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：申请电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：申请电话
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：所在城市
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：所在城市
     */
    public String getAddress() {
        return address;
    }
}
