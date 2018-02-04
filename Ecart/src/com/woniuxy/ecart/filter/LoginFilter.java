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
		// ǿת
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// ��ȡ�����uri
		String uri = request.getRequestURI();
		// ��¼login.jsp��ע��register.jsp����Ʒչʾ����goodsdisplay.jsp�ڲ���¼������¿���ֱ�ӷ��ʣ��������繺�ﳵ����Ҫ��¼���ܷ��ʡ�
		if (uri.endsWith("Ecart/") || uri.endsWith("login.jsp") || uri.endsWith("register.jsp")
				|| uri.endsWith("goodsdisplay.jsp")) {
			// ��ȡ����request��session
			HttpSession session = request.getSession(true);
			// ���session��û���û���userName��˵���û�û�е�¼
			if (session.getAttribute("userName") == null) {
				// �ض�������¼ҳ��
				response.sendRedirect("login.jsp");
				return;
			}
		}
		else{
			//���й���
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
