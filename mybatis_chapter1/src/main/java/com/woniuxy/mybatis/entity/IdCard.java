package com.woniuxy.mybatis.entity;

public class IdCard {
	private Integer id;
	private Integer student_id;
	private String natives;
	private String issue_date;
	private String end_date;
	private String tnote;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getNatives() {
		return natives;
	}
	public void setNatives(String natives) {
		this.natives = natives;
	}
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getTnote() {
		return tnote;
	}
	public void setTnote(String tnote) {
		this.tnote = tnote;
	}

	
	
}
