package com.woniuxy.hibernate.test;

import org.junit.Test;

import com.woniuxy.hibernate.dao.impl.UserDao;
import com.woniuxy.hibernate.entity.User;

public class UserDaoTest {
	/**
	 * 用于保存数据到数据库
	 */
	@Test
	public void save(){
		UserDao userDao=new UserDao();
		User user=new User();
		//设置user对象中属性
		user.setName("张三");
		user.setSex("男");
		//user对象保存到数据库中
		userDao.persist(user);
	}
	/**
	 * 用于查找数据库中的数据，通过id
	 */
	@Test
	public void find(){
		UserDao dao=new UserDao();
		//调用dao对象里面的find方法，传入要查找的id信息。
		User user = dao.find(2);
		//在控制台输出查找的用户信息
		System.out.println(user.getName());
	}
	/**
	 * 用于更新数据库的信息
	 */
	@Test
	public void update(){
		UserDao dao=new UserDao();
		//创建hql语句
		String hql="update User set name=? where id=?";
		//调用dao对象里面通过jpal更新用户信息的方法。
		dao.executeUpdateByJpql(hql, "赵六",1);
	}
	
}
