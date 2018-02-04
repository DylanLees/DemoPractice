package com.woniuxy.studentsms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.studentsms.service.RegisterService;

/**
 * 用户信息注册RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面注册时输入的信息
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String confirmPass = request.getParameter("confirmPass");
		String verCode=request.getParameter("verCode");
		
		// 实例化RegisterService类
		RegisterService reg = new RegisterService();
		// 调用reg对象里面的用户注册信息校验方法checkRegister(),并返回一个布尔值，判断是否注册成功。
		boolean re = reg.checkRegister(userName, userPass, confirmPass);
		if (re) {
			System.out.println("注册成功");
			// 注册成功跳转至登录界面
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		} else {
			System.out.println("注册失败，请重新注册");
			// 注册失败，停留在注册界面
			response.sendRedirect("jsp/register.jsp");
		}

	}

}
