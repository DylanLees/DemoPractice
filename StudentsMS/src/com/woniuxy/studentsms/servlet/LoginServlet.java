package com.woniuxy.studentsms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniuxy.studentsms.dao.po.Vi_StudentsPO;
import com.woniuxy.studentsms.service.LoginService;
import com.woniuxy.studentsms.service.ShowService;

/**
 * ��¼��Servlet
 * 
 * @author Administrator
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҳ����Ӧ������
		String userName = request.getParameter("userName");// "userName"������html�ĵ���name����
		String userPass = request.getParameter("userPass");
		// ���û�����Ŷ�request��,�Լ�ֵ�Եķ�ʽ���д洢��
		request.setAttribute("userName", userName);
		// ����Session
		HttpSession session = request.getSession(true);
		// ����context������
		ServletContext context = request.getServletContext();
		// ����Ϣ��ŵ�ServletContext��
		context.setAttribute("context", context);
		// ʵ����һ��LoginService���󣬽����û���¼����֤��
		LoginService logs = new LoginService();
		// ʵ����ShowService��
		ShowService show = new ShowService();
		// ����show���������showAll()��������ѧ����Ϣ�ļ���
		List<Vi_StudentsPO> studentsInfo = show.showAll();
		// �ѻ�ȡ��ѧ����ϢstudentsInfo�������request��
		session.setAttribute("studentsInfo", studentsInfo);
		// ����ͨ��ҳ���ȡ���û���������,������һ�����Ϊ����ֵ���жϵ�¼�Ƿ�ɹ���
		boolean re = logs.checkLogin(userName, userPass);
		System.out.println(re);
		if (re) { // ������Ϊtrue�������¼�ɹ�
			System.out.println("��¼�ɹ�");
			// ��¼�ɹ�֮����ת����ʾҳ�棬ͨ������ת���ķ�ʽ
			request.getRequestDispatcher("jsp/show.jsp").forward(request, response);
		} else {
			System.out.println("��¼ʧ��");
			// ��¼ʧ��֮��ͨ���ض���ķ�ʽ��ת��ָ����ҳ��
			response.sendRedirect("");
		}
	}

}
