package com.woniuxy.studentsms.dao.po;

/**
 * ���ڴ洢ѧ����Ϣ��ʧѪģ��
 * @author Administrator
 *
 */
public class StudentsPO {
	private int id;//����
	private String sname;//ѧ������
	private String sex;//�Ա�
	private int age;//����
	private String major;//רҵ
	private int uid;//�༶���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
