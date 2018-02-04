package com.woniuxy.hibernate.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GenericGenerator(name="order" ,strategy = "com.woniuxy.hibernate.entity.OrderIdentifierGenerator")
	@GeneratedValue(generator="order")
	private String id;//����
	private String name;//����
	private Date createTime;//����ʱ��
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
