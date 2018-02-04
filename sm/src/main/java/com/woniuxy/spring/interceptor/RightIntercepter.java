package com.woniuxy.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����Ȩ�޹�������
 * 
 * @author Administrator
 *
 */
public class RightIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// �ж��û��Ƿ��¼�����ȴ�session�л�ȡ�û�����Ϣ
		Object user = request.getSession().getAttribute("user");
		if (user != null) {// �û���Ϣ��Ϊ�գ��û����ڣ�����Խ�����һ������
			return true;

		}
		// �û�δ��¼������ת����¼����
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("���������֮����ͼ��Ⱦ���֮ǰ");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��ͼ��Ⱦ֮��������Ӧ���");

	}

}
