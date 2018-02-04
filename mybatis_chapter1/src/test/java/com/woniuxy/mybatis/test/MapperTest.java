package com.woniuxy.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.woniuxy.mybatis.entity.User;
import com.woniuxy.mybatis.entity.UserMapper;

public class MapperTest {

	// 获取builder
	private SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	private SqlSessionFactory sessionFactory;

	@Before
	public void before() {
		// 加载配置文件
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			// 获取sessionFactory
			sessionFactory = builder.build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After
	public void after() {
		if (sessionFactory != null) {
			sessionFactory = null;
		}
	}

	/**
	 * 插入用户信息
	 */
	@Test
	public void save() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		User user = new User();
		user.setCnname("李四");
		user.setEmail("12345");
		user.setMobile("123458799");
		user.setNote("蜗牛学院");
		user.setSex(1);
		user.setUserName("李无");
		// 插入用户数据
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.save(user);
		sqlSession.commit();
		sqlSession.close();
		System.err.println(user.getId());

	}

	/**
	 * 通过用户id查询用户信息
	 */
	@Test
	public void findUserInfoById() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findInfoById(2);
		System.err.println(user.getCnname());
		sqlSession.close();
	}

	/**
	 * 通过用户名查询用户信息
	 * 
	 * @throws IOException
	 */
	@Test
	public void findUserInfoByName() throws IOException {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> infoByName = (List<User>) userMapper.findInfoByName("李%");
		for (User user : infoByName) {
			
			System.err.println(user.getCnname());
		}
		sqlSession.close();

	}

	/**
	 * 通过用户id删除用户信息
	 */
	@Test
	public void deleteUserInfoById() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.delete(2);
		sqlSession.commit();
		sqlSession.close();

	}

	/**
	 * 更新用户信息
	 */

	@Test
	public void updateInfoByid() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUserName("王五");
		user.setId(11);
		userMapper.update(user);
		sqlSession.commit();
		sqlSession.close();

	}

}
