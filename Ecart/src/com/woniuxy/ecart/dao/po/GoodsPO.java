package com.woniuxy.ecart.dao.po;

/**
 * ��Ʒ�����PO
 * 
 * @author Administrator
 *
 */
public class GoodsPO {
	// �����Ա����
	private int id;// ����
	private String goodsName;// ��Ʒ����
	private String price;// �۸�
	private String inventory;// ���
	private String feature;// �ص�
	private String product_site;// ����
	private String picture_name;// ͼƬ����

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void goods(int id) {
		this.id = id;
	}

	// ����setter��getter����
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
