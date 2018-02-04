package com.woniuxy.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GenericGenerator(strategy = "com.woniuxy.hibernate.entity.OrderIdentifierGenerator", name = "orderId")
	@GeneratedValue(generator ="orderId")
	private String id;
	private String name;
	@Column(name="age",unique=true,nullable=false)
	private Integer age;
	@Formula("(select count(1) from orders  as o where o.id=id)")
	private Integer count;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
