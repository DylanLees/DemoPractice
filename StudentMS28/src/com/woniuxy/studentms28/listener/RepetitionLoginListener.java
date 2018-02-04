package com.woniuxy.studentms28.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class RepetitionLoginListener implements HttpSessionAttributeListener {
	//所有用户的session对象
	Map<String,HttpSession> map = new HashMap<String,HttpSession>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//说明登陆验证成功
		HttpSession session= arg0.getSession();
		Object obj = session.getAttribute("account");//李四
		if(obj != null){//登陆验证成功
			String account = (String)obj;
			HttpSession oldSession =  map.get(account);
			//同一个账号两个客户端在登陆
			if(oldSession != null &&!oldSession.getId().equals(session.getId())){
				oldSession.removeAttribute("account");
			}
			//将sesison以账号作为健存在在map中
			map.put(account, session);
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
