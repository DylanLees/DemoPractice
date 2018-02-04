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
 * AuthorityFilter��Ȩ�޹��ˡ�
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
		// ��ȡ��Ӧ
		HttpServletRequest req = (HttpServletRequest) request;
		// ��ȡ����
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		System.out.println(uri);
		// ����Ȩ�ޣ��޶�ֻ�У���¼��ע�������û��Ȩ�޵������ֱ�ӷ��ʡ�
		if (!(uri.endsWith("StudentsMS/") || uri.endsWith("login.jsp") || uri.endsWith("register.jsp"))) {
			// ��ȡsession����
			HttpSession session = req.getSession(true);
			// �жϸ��û��˺��Ƿ��Ѿ�����¼
			if (session.getAttribute("userName") == null) {
				// ��ת����¼����
				res.sendRedirect("login.jsp");
				return;
			}
			else{
				session.removeAttribute("userName");
				res.sendRedirect("login.jsp");
				return;
			}
		}
		// ��ȡ����������
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
