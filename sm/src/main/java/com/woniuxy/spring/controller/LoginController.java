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
	 * 处理器的参数，原生的ServletAPI
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
		// 获取登录用户名
		String user_name = request.getParameter("user_name");
		// 获取登录密码
		String user_pass = request.getParameter("user_pass");
		// 调用验证用户信息的方法
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
	 * 基本类型的数据，参数名称要和提交的参数名称保持一致
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
			//登录成功跳转至list界面
			mv.setViewName("redirect:../UserController/list");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}

	/**
	 * 简单的POJO对象：对象的属性名称要和提交的参数名称一致
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
	 * 支持MV对象和model
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
//			mv.addObject("users", this.userService.findByExample(null));//将数据存储在request域中
			mv.setViewName("redirect:../UserController/list");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}

}
