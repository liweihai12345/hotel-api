package com.platform.payinterface.activity.model;

import java.util.ArrayList;
import java.util.List;

public class ActivityModel {

	private Integer id;
	private String title;
	private String tag;
	private String tag_color;
	private String start_time;
	private String end_time;
	private String image;
	private Integer cond_type;
	private Double cond_money;
	private Integer cond_count;
	private String cond_prod_ids;
	private Integer exec_type;
	private Double exec_money;
	private String exec_counpon_ids;
	private Integer exec_credits;
	private String exec_prod_ids;
	private Double exec_discount;
	private String exec_offline_ids;
	private Boolean is_open;
	private Integer type;
	private Integer exec_card;
	private List<ShopCarGiftModel> gift=new ArrayList<ShopCarGiftModel>();
	private Integer product_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTag_color() {
		return tag_color;
	}
	public void setTag_color(String tag_color) {
		this.tag_color = tag_color;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getCond_type() {
		return cond_type;
	}
	public void setCond_type(Integer cond_type) {
		this.cond_type = cond_type;
	}
	public Double getCond_money() {
		return cond_money;
	}
	public void setCond_money(Double cond_money) {
		this.cond_money = cond_money;
	}
	public Integer getCond_count() {
		return cond_count;
	}
	public void setCond_count(Integer cond_count) {
		this.cond_count = cond_count;
	}
	public String getCond_prod_ids() {
		return cond_prod_ids;
	}
	public void setCond_prod_ids(String cond_prod_ids) {
		this.cond_prod_ids = cond_prod_ids;
	}
	public Integer getExec_type() {
		return exec_type;
	}
	public void setExec_type(Integer exec_type) {
		this.exec_type = exec_type;
	}
	public Double getExec_money() {
		return exec_money;
	}
	public void setExec_money(Double exec_money) {
		this.exec_money = exec_money;
	}
	public String getExec_counpon_ids() {
		return exec_counpon_ids;
	}
	public void setExec_counpon_ids(String exec_counpon_ids) {
		this.exec_counpon_ids = exec_counpon_ids;
	}
	public Integer getExec_credits() {
		return exec_credits;
	}
	public void setExec_credits(Integer exec_credits) {
		this.exec_credits = exec_credits;
	}
	public String getExec_prod_ids() {
		return exec_prod_ids;
	}
	public void setExec_prod_ids(String exec_prod_ids) {
		this.exec_prod_ids = exec_prod_ids;
	}
	public Double getExec_discount() {
		return exec_discount;
	}
	public void setExec_discount(Double exec_discount) {
		this.exec_discount = exec_discount;
	}
	public String getExec_offline_ids() {
		return exec_offline_ids;
	}
	public void setExec_offline_ids(String exec_offline_ids) {
		this.exec_offline_ids = exec_offline_ids;
	}
	public Boolean getIs_open() {
		return is_open;
	}
	public void setIs_open(Boolean is_open) {
		this.is_open = is_open;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getExec_card() {
		return exec_card;
	}
	public void setExec_card(Integer exec_card) {
		this.exec_card = exec_card;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public List<ShopCarGiftModel> getGift() {
		return gift;
	}
	public void setGift(List<ShopCarGiftModel> gift) {
		this.gift = gift;
	}
	
}
