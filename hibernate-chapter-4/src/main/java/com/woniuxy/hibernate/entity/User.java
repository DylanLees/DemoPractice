package com.woniuxy.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // ����ʵ��ע��
@Table(name = "users") // ���ñ��ע�⣬name��ʾ���ԣ�users�����ݿ��б������
public class User {

	@Id // ����idע��
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �����������ɲ���
	private Integer id;// ����
	@Column  //������ͨ�е�ע�⣬��ͨ�е�ע�⣬��������Ҳ���Բ������á�
	private String name;// ����
	private String sex;// �Ա�

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
