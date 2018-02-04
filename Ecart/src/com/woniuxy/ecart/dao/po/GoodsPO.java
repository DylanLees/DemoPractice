package com.woniuxy.ecart.dao.po;

/**
 * 商品详情的PO
 * 
 * @author Administrator
 *
 */
public class GoodsPO {
	// 定义成员变量
	private int id;// 主键
	private String goodsName;// 商品名称
	private String price;// 价格
	private String inventory;// 库存
	private String feature;// 特点
	private String product_site;// 产地
	private String picture_name;// 图片名称

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void goods(int id) {
		this.id = id;
	}

	// 定义setter和getter方法
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getProduct_site() {
		return product_site;
	}

	public void setProduct_site(String product_site) {
		this.product_site = product_site;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

}
