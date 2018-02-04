package com.woniuxy.studentms28.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.studentms28.dao.po.Vi_students_classPO;
import com.woniuxy.studentms28.service.DeleteService;
import com.woniuxy.studentms28.service.SearchStudentsService;

public class DeleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
//		System.out.println(sid);
		boolean re = new DeleteService().deleteById(sid);
		System.out.println(re);
		if(re){
			List<Vi_students_classPO> list = new SearchStudentsService().getStudentsInfo();
			request.setAttribute("students", list);
			request.getRequestDispatcher("JSP/main.jsp").forward(request, response);
		}
	}

}
