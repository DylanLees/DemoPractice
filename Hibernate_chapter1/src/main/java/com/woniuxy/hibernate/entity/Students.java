package com.woniuxy.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
	// @Id
	// @GenericGenerator(strategy = "uuid", name = "uuid")
	// @GeneratedValue(generator = "uuid")
	// @Id
	// @GenericGenerator(strategy = "increment", name = "myincrement")
	// @GeneratedValue(generator = "myincrement")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String addr;
	@ManyToOne(targetEntity = Teachers.class) // 设置多对一的映射关系。
	private Teachers teacher;
	@ManyToMany(targetEntity = Subjects.class, cascade = CascadeType.PERSIST)
	private Set<Subjects> subjects;

	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teachers getTeacher() {
		return teacher;
	}

	public void setTeacher(Teachers teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
