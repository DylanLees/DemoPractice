package com.woniuxy.studentsms.service;

import java.util.List;

import com.woniuxy.studentsms.dao.StudentsDAO;

import com.woniuxy.studentsms.dao.po.Vi_StudentsPO;

public class ShowService {

	public List<Vi_StudentsPO> showAll() {
		// ����һ�����϶������ڴ洢ѧ����Ϣ
		List<Vi_StudentsPO> studentsInfo = null;
		// ʵ����StudentsDAO��
		StudentsDAO sdo = new StudentsDAO();
		// ����sdo���������ѯѧ��������Ϣ�ķ���
		studentsInfo = sdo.showAllInfo();
		return studentsInfo;
	}

}
