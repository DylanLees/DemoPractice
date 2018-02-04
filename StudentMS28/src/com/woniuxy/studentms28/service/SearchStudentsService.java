package com.woniuxy.studentms28.service;

import java.util.List;

import com.woniuxy.studentms28.dao.Vi_students_classDAO;
import com.woniuxy.studentms28.dao.po.Vi_students_classPO;

public class SearchStudentsService {
	public List<Vi_students_classPO> getStudentsInfo() {
		List<Vi_students_classPO> list = null;
		Vi_students_classDAO dao = new Vi_students_classDAO();
		list = dao.findAll();
		return list;
	}
}
