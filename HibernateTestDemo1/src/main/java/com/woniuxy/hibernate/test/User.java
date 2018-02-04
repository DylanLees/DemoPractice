package com.woniuxy.hibernate.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="users")
@Entity//标识该是一个实体类对象
public class User {
	@Id//该属性为主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)//设置主键生成策略
 private Integer id;
	@Column//设置该为普通列
 private String username;
 private String userpass;
 private Integer age;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpass() {
	return userpass;
}
public void setUserpass(String userpass) {
	this.userpass = userpass;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
}
