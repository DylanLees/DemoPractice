package com.woniuxy.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController2  {
	@RequestMapping(value="/login2.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		//��ȡ��¼�û���
		String userName=request.getParameter("userName");
		//��ȡ��¼����
		String Password=request.getParameter("password");
		if(userName.equals("admin")&&Password.equals("admin")){
			mv.setViewName("success");
		}
		else{
			mv.setViewName("fail");
		}
		
		
		return mv;
	}

}
