package com.woniuxy.studentsms.service;

import java.util.List;

import com.woniuxy.studentsms.dao.StudentsDAO;

import com.woniuxy.studentsms.dao.po.Vi_StudentsPO;

public class ShowService {

	public List<Vi_StudentsPO> showAll() {
		// 创建一个集合对象用于存储学生信息
		List<Vi_StudentsPO> studentsInfo = null;
		// 实例化StudentsDAO类
		StudentsDAO sdo = new StudentsDAO();
		// 调用sdo对象里面查询学生所有信息的方法
		studentsInfo = sdo.showAllInfo();
		return studentsInfo;
	}

}
