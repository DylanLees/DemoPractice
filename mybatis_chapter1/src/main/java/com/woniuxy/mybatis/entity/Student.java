package com.woniuxy.mybatis.entity;

import java.util.List;

public class Student {

	private Integer id;
	private String cnname;
	private Integer sex;
	private String note;
	private IdCard idCard;
	private List<Health> health;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCnname() {
		return cnname;
	}
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	public List<Health> getHealth() {
		return health;
	}
	public void setHealth(List<Health> health) {
		this.health = health;
	}
	
	
	

}
