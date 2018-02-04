package com.woniuxy.ecart.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * ���ظ���¼������
 * 
 * @author Administrator
 *
 */
public class RepetitionListener implements HttpSessionAttributeListener {
	// ����һ��map�������ڴ洢��¼�û���session����
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// ������ǰ�û���session����
		HttpSession session = arg0.getSession();
		// ��ȡ��ǰ�û���sessionId
		String sessionId = session.getId();
		Object obj = session.getAttribute("userName");
		if (obj != null) {
			// ǿ��ת��
			String userName = (String) obj;
			// ͨ���û�������map���������session����
			HttpSession oldSession = map.get(userName);
			// �жϣ���ǰ�û���session��map�����session��sessionId�Ƿ���ͬ,�����ͬ���ظ���¼�������ͬ�����ǵ�һ�ε�¼��
			if (oldSession != null && sessionId.equals(oldSession.getId())) {
				// ˵�����û��Ѿ��ڱ𴦵�¼����ɾ�������ط���¼��session��������Ӧ���û���
				oldSession.removeAttribute("userName");
			}
			// ����ǰ�û����û�����session�����map������
			map.put(userName, session);

		}

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

}
