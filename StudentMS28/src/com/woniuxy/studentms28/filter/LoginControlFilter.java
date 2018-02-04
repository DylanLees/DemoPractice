package com.woniuxy.studentms28.filter;

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

public class LoginControlFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String uri = request.getRequestURI();
//		System.out.println(uri);
		//排除登陆和注册页面的访问
		if(uri.endsWith("StudentMS28/") || uri.endsWith("login.jsp") 
				|| uri.endsWith("register.jsp")){
			arg2.doFilter(arg0, arg1);
		}else{
			//其他页面访问控制
			HttpSession session = request.getSession(true);
			Object obj = session.getAttribute("account");
			//没有登陆
			if(obj == null){
				response.sendRedirect("login.jsp");
			}else{
				arg2.doFilter(arg0, arg1);
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
