package com.woniuxy.ecart.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 强转
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 获取请求的uri
		String uri = request.getRequestURI();
		// 登录login.jsp、注册register.jsp、商品展示界面goodsdisplay.jsp在不登录的情况下可以直接访问，其他比如购物车，需要登录才能访问。
		if (uri.endsWith("Ecart/") || uri.endsWith("login.jsp") || uri.endsWith("register.jsp")
				|| uri.endsWith("goodsdisplay.jsp")) {
			// 获取请求request的session
			HttpSession session = request.getSession(true);
			// 如果session中没有用户名userName就说明用户没有登录
			if (session.getAttribute("userName") == null) {
				// 重定向至登录页面
				response.sendRedirect("login.jsp");
				return;
			}
		}
		else{
			//进行过滤
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
