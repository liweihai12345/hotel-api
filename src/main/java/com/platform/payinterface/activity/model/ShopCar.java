package com.platform.payinterface.activity.model;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ShopCar implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8938736780023777927L;
    private Integer uid;
    private Integer product_id;
    private String product_name;
    private String product_image_url;
    private Double length;
    private Double width;
    private Double height;
    private Integer number;
    private Double price;
    private Double discount;
    private Double price_multi;
    private String material_id;
    private String materialname;
    private Integer category_id;
    private String categoryname;
    private Integer style_id;
    private String stylename;
    private String fittingids;
    private String oldfittingids;
    private String fittingname;
    private String fittings_group_ids;
    private Integer max_height;
    private Double base_size_height;
    private String activity_image;
    private List<FittingModel> fitList;

    private Integer activity_id;
    private String customized_code;
    private Integer customized_type;
    private Integer is_collect;

    public ShopCar(Integer uid, Integer product_id, Integer style_id, String fittingids, String fittings_group_ids,
                   String oldfittingids, Double discount, Double price_multi) {
        this.uid = uid;
        this.product_id = product_id;
        this.style_id = style_id;
        this.fittingids = fittingids;
        this.fittings_group_ids = fittings_group_ids;
        this.oldfittingids = oldfittingids;
        this.price_multi = price_multi;
        this.discount = discount;
    }

    public String getCustomized_code() {
        return customized_code;
    }

    public Integer getCustomized_type() {
        return customized_type;
    }

    public void setCustomized_code(String customized_code) {
        this.customized_code = customized_code;
    }

    public void setCustomized_type(Integer customized_type) {
        this.customized_type = customized_type;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public List<String> getFitidList() {
        if (this.getFittingids() != null) {
            String[] fid = this.getFittingids().split("-");
            List<String> list = Arrays.asList(fid);
            return list;
        }
        return null;
    }

    public List<String> getGroupIdList() {
        if (this.getFittings_group_ids() != null) {
            String[] fid = this.getFittings_group_ids().split("-");
            List<String> list = Arrays.asList(fid);
            return list;
        }
        return null;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_image_url() {
        return product_image_url;
    }

    public void setProduct_image_url(String product_image_url) {
        this.product_image_url = product_image_url;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getStyle_id() {
        return style_id;
    }

    public void setStyle_id(Integer style_id) {
        this.style_id = style_id;
    }

    public String getStylename() {
        if (StringUtils.isEmpty(style_id) && this.customized_type == 1) {
            stylename = "自选";
        } else if (StringUtils.isEmpty(style_id) && this.customized_type == 3) {
            stylename = "定制";
        }
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename;
    }

    public String getFittingids() {
        return fittingids;
    }

    public void setFittingids(String fittingids) {
        this.fittingids = fittingids;
    }

    public String getFittingname() {
        if (this.fitList != null && fitList.size() > 0) {
            fittingname = "";
            for (int i = 0; i < fitList.size(); i++) {
                if (i >= 1) {
                    fittingname += "-";
                }
                fittingname += fitList.get(i).getName();
            }
        }
        return fittingname;
    }

    public void setFittingname(String fittingname) {
        this.fittingname = fittingname;
    }

    public Double getBase_size_height() {
        return base_size_height;
    }

    public void setBase_size_height(Double base_size_height) {
        this.base_size_height = base_size_height;
    }

    public Integer getMax_height() {
        if (this.max_height == null) {
            return 0;
        }
        return max_height;
    }

    public void setMax_height(Integer max_height) {
        this.max_height = max_height;
    }

    public List<FittingModel> getFitList() {
        return fitList;
    }

    public void setFitList(List<FittingModel> fitList) {
        this.fitList = fitList;
    }

    public String contactMateName() {
        String matename = "";
        if (this.getFitList() != null && this.getFitList().size() > 0) {
            for (int i = 0; i < fitList.size(); i++) {
                if (i >= 1) {
                    matename += "-";
                }
                matename += fitList.get(i).getMaterialname();
            }

        }
        return matename;

    }

    public String contactMateid() {
        String mateid = "";
        if (this.getFitList() != null && this.getFitList().size() > 0) {
            for (int i = 0; i < fitList.size(); i++) {
                if (i >= 1) {
                    mateid += "-";
                }
                mateid += fitList.get(i).getId().toString();
            }

        }
        return mateid;
    }

    public String getFittings_group_ids() {
        return fittings_group_ids;
    }

    public void setFittings_group_ids(String fittings_group_ids) {
        this.fittings_group_ids = fittings_group_ids;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPrice_multi() {
        return price_multi;
    }

    public void setPrice_multi(Double price_multi) {
        this.price_multi = price_multi;
    }

    public String getActivity_image() {
        return activity_image;
    }

    public void setActivity_image(String activity_image) {
        this.activity_image = activity_image;
    }

    public Integer getIs_collect() {
        return is_collect;
    }

    public void setIs_collect(Integer is_collect) {
        this.is_collect = is_collect;
    }

    public String getOldfittingids() {
        return oldfittingids;
    }

    public void setOldfittingids(String oldfittingids) {
        this.oldfittingids = oldfittingids;
    }

    public ShopCar() {
        super();
    }


}
