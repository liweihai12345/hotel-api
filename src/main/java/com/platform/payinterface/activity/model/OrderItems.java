package com.platform.payinterface.activity.model;

import java.io.Serializable;

/**
 * 订单条目
 */
public class OrderItems implements Serializable {

	private static final long serialVersionUID = -5367658251849722552L;
	private String order_code;
	private Integer product_id;
	private String product_name;
	private String product_image_url;
	private Double length;
	private Double width;
	private Double height;
	private Double price;
	private Double discount;
	private Integer number;
	private String material_name;
	private String category_name;
	private Integer style_id;
	private String style_name;
	private String fittings_ids;
	private String fittings_name;
	private Integer max_height;
	private String fittings_group_ids;
	private String activity_code;
	private Integer activity_id;
	private Double activity_discount;
	private String activity_number;
	
	private String activity_content;
	private Integer box_id;
	private String  box_name;
	
	private String customized_code;
	private Integer customized_type;
	
	public String getBox_name() {
		return box_name;
	}
	public void setBox_name(String box_name) {
		this.box_name = box_name;
	}
	public String getActivity_content() {
		return activity_content;
	}
	public Integer getBox_id() {
		return box_id;
	}
	public String getCustomized_code() {
		return customized_code;
	}
	public Integer getCustomized_type() {
		return customized_type;
	}
	public void setActivity_content(String activity_content) {
		this.activity_content = activity_content;
	}
	public void setBox_id(Integer box_id) {
		this.box_id = box_id;
	}
	public void setCustomized_code(String customized_code) {
		this.customized_code = customized_code;
	}
	public void setCustomized_type(Integer customized_type) {
		this.customized_type = customized_type;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
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
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Integer getStyle_id() {
		return style_id;
	}
	public void setStyle_id(Integer style_id) {
		this.style_id = style_id;
	}
	public String getStyle_name() {
		return style_name;
	}
	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}
	public String getFittings_ids() {
		return fittings_ids;
	}
	public void setFittings_ids(String fittings_ids) {
		this.fittings_ids = fittings_ids;
	}
	public String getFittings_name() {
		return fittings_name;
	}
	public void setFittings_name(String fittings_name) {
		this.fittings_name = fittings_name;
	}
	public Integer getMax_height() {
		return max_height;
	}
	public void setMax_height(Integer max_height) {
		this.max_height = max_height;
	}
	public String getFittings_group_ids() {
		return fittings_group_ids;
	}
	public void setFittings_group_ids(String fittings_group_ids) {
		this.fittings_group_ids = fittings_group_ids;
	}
	public String getActivity_code() {
		return activity_code;
	}
	public void setActivity_code(String activity_code) {
		this.activity_code = activity_code;
	}
	public Integer getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}
	public Double getActivity_discount() {
		return activity_discount;
	}
	public void setActivity_discount(Double activity_discount) {
		this.activity_discount = activity_discount;
	}
	public String getActivity_number() {
		return activity_number;
	}
	public void setActivity_number(String activity_number) {
		this.activity_number = activity_number;
	}


	
	
}
