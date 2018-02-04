package com.woniuxy.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.woniuxy.mybatis.entity.User;
import com.woniuxy.mybatis.entity.Uuid;

public class UserTest {
	/**
	 * 通过id查询用户信息
	 */
	@Test
	public void findUserById(){
		try {
			//加载配置文件
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//构建设计模式,构建复杂对象
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//创建sqlSessionFactory工厂
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//创建sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * 第一参数，执行sql语句的id namespace+id
			 * 第二参数，执行sql语句的形参
			 */
			//查询一个结果
			User user=sqlSession.selectOne("test.findUserById", 1);
			//关闭sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
			System.out.println(user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 通过用户名查询用户信息
	 */
	@Test
	public void findUserByCnname(){
		try {
			//加载配置文件
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//构建设计模式,构建复杂对象
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//创建sqlSessionFactory工厂
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//创建sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * 第一参数，执行sql语句的id namespace+id
			 * 第二参数，执行sql语句的形参
			 */
			//查询一个结果
			List<User> user= sqlSession.selectList("test.findUserByCnname", "赵%");
			//关闭sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
			System.out.println(user.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除用户信息
	 */
	@Test
	public void deleteUserById(){
		try {
			//加载配置文件
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//构建设计模式,构建复杂对象
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//创建sqlSessionFactory工厂
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//创建sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * 第一参数，执行sql语句的id namespace+id
			 * 第二参数，执行sql语句的形参
			 */
			//删除用户信息
			sqlSession.delete("test.deleteUserById", 2);
			//提交事务
			sqlSession.commit();
			//关闭sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新用户信息
	 */
	@Test
	public void update(){
		try {
			//加载配置文件
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//构建设计模式,构建复杂对象
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//创建sqlSessionFactory工厂
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//创建sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * 第一参数，执行sql语句的id namespace+id
			 * 第二参数，执行sql语句的形参
			 */
			//更新用户信息
			User user=new User();
			user.setCnname("王五");
			user.setId(1);
			sqlSession.update("test.update", user);
			//提交事务
			sqlSession.commit();
			//关闭sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增用户信息
	 * 
	 */
	@Test
	public void insert(){
		try {
			//加载配置文件
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//构建设计模式,构建复杂对象
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//创建sqlSessionFactory工厂
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//创建sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * 第一参数，执行sql语句的id namespace+id
			 * 第二参数，执行sql语句的形参
			 */
			//更新用户信息
			User user=new User();
			user.setUser_name("zhangang");
			user.setCnname("张昂");
			user.setSex(1);
			user.setEmail("zhaoliu@woniuxy.com");
			user.setMobile("112");
			user.setNote("蜗牛学院");
			sqlSession.insert("test.insert", user);
			//提交事务
			sqlSession.commit();
			//关闭sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
