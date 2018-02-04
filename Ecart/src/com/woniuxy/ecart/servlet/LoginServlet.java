package com.woniuxy.ecart.servlet;


import java.io.IOException;

/**
 * �����û���Ϣ��¼�Ĺ���
 */


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.ecart.service.LoginService;

public class LoginServlet extends HttpServlet {

	/**
	 * ��servlet���ڶ��û���¼��ҳ���������Ӧ
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// ��ȡҳ������Ĳ���
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println("�˺ţ�"+userName+"���룻"+password);
		//����session����
		HttpSession session=request.getSession(true);
		// ʵ����LoginService,�����������û���¼���߼��ж�
		LoginService loginService = new LoginService();
		// ����loginService����������֤�û���¼���жϣ�������һ��booleanֵ
		boolean re = loginService.checkLogin(userName, password);// ��checkLogin�������洫���˺ź�����
		if(re){
			System.out.println("��¼�ɹ�");
			//��session�����д����û���
			session.setAttribute("userName", userName);
			System.out.println(session.getAttribute("userName"));
			//��¼�ɹ�����ת����Ʒ��Ϣչʾ����
			ObjectMapper om = new ObjectMapper();
			try {
				om.writeValue(response.getOutputStream(),"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("��¼ʧ��");
			//��¼ʧ�����ض�������¼����
			try {
				response.sendRedirect("jsp/login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
