package com.woniuxy.studentms28.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.studentms28.service.RegisterService;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String pass = request.getParameter("pass");
		String checkpass = request.getParameter("checkpass");
		String vercode = request.getParameter("vercode");
		Object realVercode = request.getSession(true).getAttribute("randCheckCode");
		boolean re = new RegisterService().register(account,pass,checkpass,vercode,realVercode);
		if(re){
			response.sendRedirect("JSP/login.jsp");
		}else{
			response.sendRedirect("JSP/register.jsp");
		}
	}

}
