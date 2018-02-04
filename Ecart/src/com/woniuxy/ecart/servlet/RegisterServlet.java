package com.woniuxy.ecart.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.ecart.service.RegisterService;



/*
 * 创建与登录的Servlet
 */
public class RegisterServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面的请求参数
		String userName =request.getParameter("userName");//用户名
		String password =request.getParameter("password");//密码
		String confirmPass= request.getParameter("confirmPass");//确认密码
		String contact =request.getParameter("contact");//联系人
		String tel=request.getParameter("tel");//电话
		String mail=request.getParameter("mail");//邮箱
		String address =request.getParameter("address");//地址
	System.out.println("用户名："+userName+"联系人："+contact+"电话："+tel+"邮箱："+mail+"地址："+address);
		//实例化UserDAO
		RegisterService user=new RegisterService();
		//调用user对象里面的用户信息注册检查的方法，checkRegister(),并返回一个布尔值
		boolean re=user.checkRegister(userName,password,confirmPass,contact,tel,mail,address);
		if(re){
			
			//注册成功则跳转值用户信息登录界面
//			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
//			response.sendRedirect("jsp/login.jsp");
			ObjectMapper om = new ObjectMapper();
			om.writeValue(response.getOutputStream(),"");
			System.out.println("注册成功");
		}
		else{
			System.out.println("注册失败");
			//注册失败则重写注册
			response.sendRedirect("jsp/register.jsp");
		}
		

	}

}
