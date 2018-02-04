package com.woniuxy.ecart.servlet;


import java.io.IOException;

/**
 * 设置用户信息登录的过滤
 */


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.ecart.service.LoginService;

public class LoginServlet extends HttpServlet {

	/**
	 * 该servlet用于对用户登录的页面请求的响应
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// 获取页面请求的参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println("账号："+userName+"密码；"+password);
		//创建session对象
		HttpSession session=request.getSession(true);
		// 实例化LoginService,该类用于做用户登录的逻辑判断
		LoginService loginService = new LoginService();
		// 调用loginService里面用于验证用户登录的判断，并返回一个boolean值
		boolean re = loginService.checkLogin(userName, password);// 在checkLogin方法里面传入账号和密码
		if(re){
			System.out.println("登录成功");
			//在session对象中存入用户名
			session.setAttribute("userName", userName);
			System.out.println(session.getAttribute("userName"));
			//登录成功则跳转至商品信息展示界面
			ObjectMapper om = new ObjectMapper();
			try {
				om.writeValue(response.getOutputStream(),"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("登录失败");
			//登录失败则重定向至登录界面
			try {
				response.sendRedirect("jsp/login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
