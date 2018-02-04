package com.woniuxy.hibernate.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="users")
@Entity//��ʶ����һ��ʵ�������
public class User {
	@Id//������Ϊ����
	@GeneratedValue(strategy=GenerationType.IDENTITY)//�����������ɲ���
 private Integer id;
	@Column//���ø�Ϊ��ͨ��
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
