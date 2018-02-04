package com.woniuxy.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GenericGenerator(strategy="uuid" ,name="char_uuid")
	@GeneratedValue(generator="char_uuid")
	private String id;//����
	@Column  //��ͨ��
	private String name;//����
	private String address;//��ַ
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
