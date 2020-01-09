package com.platform.entity;
import java.io.Serializable;
import java.util.Date;

public class DynamicCategoryDO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    //分类名称
    private String name;
    //Key码
    private String keycode;
    //类型0普通，1关注，2同城，3话题 4,案例
    private Integer type;
    //图片
    private String imageUrl;
    //状态
    private Integer enabled;
    //创建日期
    private Date createdat;
    //更新日期
    private Date updatedat;
    //排序
    private Integer sortOrder;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
     * 设置：分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：分类名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：Key码
     */
    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    /**
     * 获取：Key码
     */
    public String getKeycode() {
        return keycode;
    }
    /**
     * 设置：图片
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取：图片
     */
    public String getImageUrl() {
        return imageUrl;
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
     * 设置：排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取：排序
     */
    public Integer getSortOrder() {
        return sortOrder;
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
