package com.woniuxy.studentms28.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniuxy.studentms28.dao.po.Vi_students_classPO;
import com.woniuxy.studentms28.service.LoginService;
import com.woniuxy.studentms28.service.SearchStudentsService;

public class LoginServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		System.out.println(request.getParameter("account")+request.getParameter("pass"));
		String account = request.getParameter("account");
		String pass = request.getParameter("pass");
		String vercode = request.getParameter("vercode");
		HttpSession session = request.getSession(true);
		Object realVercode = session.getAttribute("randCheckCode");
		LoginService ls = new LoginService();
		boolean re = ls.checkLogin(account, pass,vercode,realVercode);
		if(re){
//			System.out.println("登陆成功！");
			session.setAttribute("account", account);
			List<Vi_students_classPO> list = new SearchStudentsService().getStudentsInfo();
			request.setAttribute("students", list);
			request.getRequestDispatcher("JSP/main.jsp").forward(request, response);
		}else{
//			System.out.println("登陆失败！");
			response.sendRedirect("JSP/login.jsp");
		}
	}

}
