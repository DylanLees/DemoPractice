package com.woniuxy.studentsms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * AuthorityFilter，权限过滤。
 */
@WebFilter("/LoginFilter")
public class AuthorityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthorityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取响应
		HttpServletRequest req = (HttpServletRequest) request;
		// 获取请求
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		System.out.println(uri);
		// 设置权限，限定只有，登录和注册可以在没有权限的情况下直接访问。
		if (!(uri.endsWith("StudentsMS/") || uri.endsWith("login.jsp") || uri.endsWith("register.jsp"))) {
			// 获取session对象
			HttpSession session = req.getSession(true);
			// 判断该用户账号是否已经被登录
			if (session.getAttribute("userName") == null) {
				// 跳转至登录界面
				res.sendRedirect("login.jsp");
				return;
			}
			else{
				session.removeAttribute("userName");
				res.sendRedirect("login.jsp");
				return;
			}
		}
		// 获取过滤链参数
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
