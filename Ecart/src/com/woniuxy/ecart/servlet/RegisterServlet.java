package com.woniuxy.ecart.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.ecart.service.RegisterService;



/*
 * �������¼��Servlet
 */
public class RegisterServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ����������
		String userName =request.getParameter("userName");//�û���
		String password =request.getParameter("password");//����
		String confirmPass= request.getParameter("confirmPass");//ȷ������
		String contact =request.getParameter("contact");//��ϵ��
		String tel=request.getParameter("tel");//�绰
		String mail=request.getParameter("mail");//����
		String address =request.getParameter("address");//��ַ
	System.out.println("�û�����"+userName+"��ϵ�ˣ�"+contact+"�绰��"+tel+"���䣺"+mail+"��ַ��"+address);
		//ʵ����UserDAO
		RegisterService user=new RegisterService();
		//����user����������û���Ϣע����ķ�����checkRegister(),������һ������ֵ
		boolean re=user.checkRegister(userName,password,confirmPass,contact,tel,mail,address);
		if(re){
			
			//ע��ɹ�����תֵ�û���Ϣ��¼����
//			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
//			response.sendRedirect("jsp/login.jsp");
			ObjectMapper om = new ObjectMapper();
			om.writeValue(response.getOutputStream(),"");
			System.out.println("ע��ɹ�");
		}
		else{
			System.out.println("ע��ʧ��");
			//ע��ʧ������дע��
			response.sendRedirect("jsp/register.jsp");
		}
		

	}

}
