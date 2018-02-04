package com.woniuxy.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 设置实体注解
@Table(name = "users") // 引用表的注解，name表示属性，users是数据库中表的名称
public class User {

	@Id // 设置id注解
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 设置主键生成策略
	private Integer id;// 主键
	@Column  //设置普通列的注解，普通列的注解，可以设置也可以不用设置。
	private String name;// 姓名
	private String sex;// 性别

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
