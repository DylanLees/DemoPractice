package com.woniuxy.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于权限过滤拦截
 * 
 * @author Administrator
 *
 */
public class RightIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断用户是否登录过，先从session中获取用户的信息
		Object user = request.getSession().getAttribute("user");
		if (user != null) {// 用户信息不为空，用户存在，则可以进行下一步操作
			return true;

		}
		// 用户未登录过则跳转至登录界面
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("处理器完成之后，视图渲染完成之前");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("视图渲染之后，整个响应完成");

	}

}
