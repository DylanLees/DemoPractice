package com.woniuxy.hibernate.test;

import org.junit.Test;

import com.woniuxy.hibernate.dao.impl.UserDao;
import com.woniuxy.hibernate.entity.User;

public class UserDaoTest {
	/**
	 * ���ڱ������ݵ����ݿ�
	 */
	@Test
	public void save(){
		UserDao userDao=new UserDao();
		User user=new User();
		//����user����������
		user.setName("����");
		user.setSex("��");
		//user���󱣴浽���ݿ���
		userDao.persist(user);
	}
	/**
	 * ���ڲ������ݿ��е����ݣ�ͨ��id
	 */
	@Test
	public void find(){
		UserDao dao=new UserDao();
		//����dao���������find����������Ҫ���ҵ�id��Ϣ��
		User user = dao.find(2);
		//�ڿ���̨������ҵ��û���Ϣ
		System.out.println(user.getName());
	}
	/**
	 * ���ڸ������ݿ����Ϣ
	 */
	@Test
	public void update(){
		UserDao dao=new UserDao();
		//����hql���
		String hql="update User set name=? where id=?";
		//����dao��������ͨ��jpal�����û���Ϣ�ķ�����
		dao.executeUpdateByJpql(hql, "����",1);
	}
	
}
