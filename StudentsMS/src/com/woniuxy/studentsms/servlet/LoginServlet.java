package com.woniuxy.studentsms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniuxy.studentsms.dao.po.Vi_StudentsPO;
import com.woniuxy.studentsms.service.LoginService;
import com.woniuxy.studentsms.service.ShowService;

/**
 * 登录的Servlet
 * 
 * @author Administrator
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面响应的请求
		String userName = request.getParameter("userName");// "userName"来自于html文档的name属性
		String userPass = request.getParameter("userPass");
		// 把用户名存放都request中,以键值对的方式进行存储。
		request.setAttribute("userName", userName);
		// 创建Session
		HttpSession session = request.getSession(true);
		// 创建context上下文
		ServletContext context = request.getServletContext();
		// 把信息存放到ServletContext中
		context.setAttribute("context", context);
		// 实例化一个LoginService对象，进行用户登录的验证。
		LoginService logs = new LoginService();
		// 实例化ShowService类
		ShowService show = new ShowService();
		// 调用show对象里面的showAll()方法返回学生信息的集合
		List<Vi_StudentsPO> studentsInfo = show.showAll();
		// 把获取的学生信息studentsInfo，存放在request中
		session.setAttribute("studentsInfo", studentsInfo);
		// 传入通过页面获取的用户名和密码,并返回一个结果为布尔值，判断登录是否成功。
		boolean re = logs.checkLogin(userName, userPass);
		System.out.println(re);
		if (re) { // 如果结果为true则输出登录成功
			System.out.println("登录成功");
			// 登录成功之后，跳转至显示页面，通过请求转发的方式
			request.getRequestDispatcher("jsp/show.jsp").forward(request, response);
		} else {
			System.out.println("登录失败");
			// 登录失败之后，通过重定向的方式跳转至指定的页面
			response.sendRedirect("");
		}
	}

}
