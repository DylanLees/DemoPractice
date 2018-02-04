package com.woniuxy.ecart.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 防重复登录监听器
 * 
 * @author Administrator
 *
 */
public class RepetitionListener implements HttpSessionAttributeListener {
	// 创建一个map对象用于存储登录用户的session对象
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// 创建当前用户的session对象
		HttpSession session = arg0.getSession();
		// 获取当前用户的sessionId
		String sessionId = session.getId();
		Object obj = session.getAttribute("userName");
		if (obj != null) {
			// 强制转型
			String userName = (String) obj;
			// 通过用户名查找map集合里面的session对象
			HttpSession oldSession = map.get(userName);
			// 判断，当前用户的session和map里面的session的sessionId是否相同,如果相同是重复登录，如果不同，则是第一次登录。
			if (oldSession != null && sessionId.equals(oldSession.getId())) {
				// 说明该用户已经在别处登录，则删除其他地方登录的session对象所对应的用户名
				oldSession.removeAttribute("userName");
			}
			// 将当前用户的用户名和session存放在map集合中
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
