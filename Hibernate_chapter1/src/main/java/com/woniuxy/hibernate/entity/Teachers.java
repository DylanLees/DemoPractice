package com.woniuxy.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teachers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//�������ɲ��ԣ�������
	private Integer id;
	@Column(name="name" ,unique=true,nullable=false)
	private String name;
	@OneToMany(targetEntity=Students.class,cascade=CascadeType.REMOVE)//������ʦ���ѧ�������
	@JoinColumn(name="teacher_id")
	private Set<Students> students;
	

	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
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
