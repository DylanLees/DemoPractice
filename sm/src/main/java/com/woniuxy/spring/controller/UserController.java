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
	 * ��¼�ɹ����ҳ����ת
	 * 
	 * @param model
	 * @return
	 */
	/**
	 * չʾ�û���Ϣ
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String success(Model model) {
		// �û��б����
		model.addAttribute("users", this.userService.findByExample(null));
		return "user/list";
	}

	/**
	 * ɾ���û���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{uId}")
	public String delete(@PathVariable("uId") int id) {// restful��Ӧ��
		// ɾ���û�����
		this.userService.deleteById(id);
		// ɾ���ɹ�֮����ת��������,redirect��ı�url��ַ
		return "redirect:../list";
	}

	/**
	 * ʵ���û�ע��
	 * 
	 * @return
	 */
	@RequestMapping("/register")
	public String register() {

		return "register";

	}

	@RequestMapping("/doRegister")
	public String doRegister(@Validated User user, BindingResult result) {
		if (result.hasErrors()) {// У�����
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				System.err.println(objectError.getDefaultMessage());
			}
			return "register";

		}
		// 1�������û����ݵ����ݿ�
		this.userService.insert(user);
		// 2��ע��ɹ�֮����ת����¼����
		return "login";
	}

}
