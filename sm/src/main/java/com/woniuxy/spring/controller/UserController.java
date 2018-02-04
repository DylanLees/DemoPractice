package com.woniuxy.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.spring.entity.User;
import com.woniuxy.spring.service.UserService;

@Controller
@RequestMapping("/UserController")
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 登录成功后的页面跳转
	 * 
	 * @param model
	 * @return
	 */
	/**
	 * 展示用户信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String success(Model model) {
		// 用户列表界面
		model.addAttribute("users", this.userService.findByExample(null));
		return "user/list";
	}

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{uId}")
	public String delete(@PathVariable("uId") int id) {// restful的应用
		// 删除用户数据
		this.userService.deleteById(id);
		// 删除成功之后跳转至主界面,redirect会改变url地址
		return "redirect:../list";
	}

	/**
	 * 实现用户注册
	 * 
	 * @return
	 */
	@RequestMapping("/register")
	public String register() {

		return "register";

	}

	@RequestMapping("/doRegister")
	public String doRegister(@Validated User user, BindingResult result) {
		if (result.hasErrors()) {// 校验错误
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				System.err.println(objectError.getDefaultMessage());
			}
			return "register";

		}
		// 1、保存用户数据到数据库
		this.userService.insert(user);
		// 2、注册成功之后跳转至登录界面
		return "login";
	}

}
