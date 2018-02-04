package com.woniuxy.studentsms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.studentsms.service.RegisterService;

/**
 * �û���Ϣע��RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҳ��ע��ʱ�������Ϣ
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String confirmPass = request.getParameter("confirmPass");
		String verCode=request.getParameter("verCode");
		
		// ʵ����RegisterService��
		RegisterService reg = new RegisterService();
		// ����reg����������û�ע����ϢУ�鷽��checkRegister(),������һ������ֵ���ж��Ƿ�ע��ɹ���
		boolean re = reg.checkRegister(userName, userPass, confirmPass);
		if (re) {
			System.out.println("ע��ɹ�");
			// ע��ɹ���ת����¼����
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		} else {
			System.out.println("ע��ʧ�ܣ�������ע��");
			// ע��ʧ�ܣ�ͣ����ע�����
			response.sendRedirect("jsp/register.jsp");
		}

	}

}
