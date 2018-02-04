package com.woniuxy.mybatis.entity;



public interface StudentMapper {
	
	Student findStudentInfoWithIdCardById(int id);
	Student findStudentInfoWithHealthById(int id);
	Student findStudentInfoWithLazyLoadById(int id);
	Student findStudentInfoById(int id);
}
