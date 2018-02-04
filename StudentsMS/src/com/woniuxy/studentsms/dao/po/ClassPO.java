package com.woniuxy.studentsms.dao.po;

/**
 * 用于存储学生班级信息的失血模型
 * @author Administrator
 *
 */
public class ClassPO {
	private int id;//主键
	private String cname;//班级名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
