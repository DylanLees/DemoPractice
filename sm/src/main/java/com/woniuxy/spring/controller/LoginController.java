package com.woniuxy.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.spring.entity.User;
import com.woniuxy.spring.service.UserService;

@Controller
@RequestMapping("/LoginController")
public class LoginController {
	@Resource
	private UserService userService;

	/**
	 * �������Ĳ�����ԭ����ServletAPI
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		// ��ȡ��¼�û���
		String user_name = request.getParameter("user_name");
		// ��ȡ��¼����
		String user_pass = request.getParameter("user_pass");
		// ������֤�û���Ϣ�ķ���
		User user = this.userService.validateUserInfo(user_name, user_pass);

		if (user != null) {
			session.setAttribute("user", user);
			mv.setViewName("redirect:../UserController/list");
		} else {
			mv.setViewName("fail");
		}

		return mv;
	}

	/**
	 * �������͵����ݣ���������Ҫ���ύ�Ĳ������Ʊ���һ��
	 * 
	 * @param user_name
	 * @param user_pass
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public ModelAndView login1(String user_name, String user_pass, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = this.userService.validateUserInfo(user_name, user_pass);
		if (user != null) {
			session.setAttribute("user", user);
			//��¼�ɹ���ת��list����
			mv.setViewName("redirect:../UserController/list");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}

	/**
	 * �򵥵�POJO���󣺶������������Ҫ���ύ�Ĳ�������һ��
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public ModelAndView login2(User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		user = this.userService.validateUserInfo(user.getUser_name(), user.getUser_pass());
		if (user != null) {
			session.setAttribute("user", user);
			mv.setViewName("redirect:../UserController/list");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}

	/**
	 * ֧��MV�����model
	 * 
	 * @param mv
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login3", method = RequestMethod.POST)
	public ModelAndView login3(User user, ModelAndView mv, HttpSession session) {

		user = this.userService.validateUserInfo(user.getUser_name(), user.getUser_pass());
		if (user != null) {
			session.setAttribute("user", user);
//			mv.addObject("users", this.userService.findByExample(null));//�����ݴ洢��request����
			mv.setViewName("redirect:../UserController/list");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}

}
