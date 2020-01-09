package com.platform.payinterface.activity.model;

import java.io.Serializable;
import java.util.Date;

public class ActivityRecord implements Serializable {
	private static final long serialVersionUID = -5367658251849722552L;

	private Integer id;
	private Integer product_id;
	private Integer discount_activity_id;
	private String order_code;
	private String numbers_code;
	private Date order_add_time;
	private Double old_price;
	private Double new_price;
	private Integer is_transaction;
	private Double discount_activity_discount;
	private String record_unique_key;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getDiscount_activity_id() {
		return discount_activity_id;
	}
	public void setDiscount_activity_id(Integer discount_activity_id) {
		this.discount_activity_id = discount_activity_id;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getNumbers_code() {
		return numbers_code;
	}
	public void setNumbers_code(String numbers_code) {
		this.numbers_code = numbers_code;
	}
	public Date getOrder_add_time() {
		return order_add_time;
	}
	public void setOrder_add_time(Date order_add_time) {
		this.order_add_time = order_add_time;
	}
	public Double getOld_price() {
		return old_price;
	}
	public void setOld_price(Double old_price) {
		this.old_price = old_price;
	}
	public Double getNew_price() {
		return new_price;
	}
	public void setNew_price(Double new_price) {
		this.new_price = new_price;
	}
	public Integer getIs_transaction() {
		return is_transaction;
	}
	public void setIs_transaction(Integer is_transaction) {
		this.is_transaction = is_transaction;
	}
	public Double getDiscount_activity_discount() {
		return discount_activity_discount;
	}
	public void setDiscount_activity_discount(Double discount_activity_discount) {
		this.discount_activity_discount = discount_activity_discount;
	}
	public String getRecord_unique_key() {
		return record_unique_key;
	}
	public void setRecord_unique_key(String record_unique_key) {
		this.record_unique_key = record_unique_key;
	}
	


}
