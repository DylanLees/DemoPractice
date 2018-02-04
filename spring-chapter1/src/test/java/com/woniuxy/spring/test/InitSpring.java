package com.woniuxy.spring.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniuxy.spring.beans.UserAction;
import com.woniuxy.spring.beans.UserAction1;

public class InitSpring {

	@Test
	public void initSpring() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
//		System.out.println(context);
//		UserAction bean = act.getBean(UserAction.class);
//		System.out.println(bean);
//		Object object = act.getBean("userAction");
//		Object object = act.getBean("userAction1");
		Object object = act.getBean("userAction2");
		UserAction action=(UserAction)object;
		action.save();	
		
	}
	@SuppressWarnings("resource")
	@Test
	public void springTest(){
		//获取Bean对象的一个实例
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		//获取Bean对象
		UserAction1 action1 = context.getBean(UserAction1.class);
		action1.save();
		System.out.println("*****************************");
		//获取Bean的对象的实例
		UserAction1 action2 = context.getBean(UserAction1.class);
		action2.save();
	}
}
