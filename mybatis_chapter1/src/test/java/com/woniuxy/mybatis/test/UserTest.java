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
import com.woniuxy.mybatis.entity.Uuid;

public class UserTest {
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
		user.setUserName("oldsix");
		// 插入用户数据
		sqlSession.insert("test.insert", user);// "test.insert"是namespace+id组成
		sqlSession.commit();
		sqlSession.close();
		System.err.println(user.getId());

	}

	@Test
	public void findUserInfoById() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		Object object = sqlSession.selectOne("test.findUserInfoById", 10);
		User user = (User) object;
		sqlSession.close();
		System.err.println(user.getCnname());

	}

	@Test
	public void findUserInfoByName() throws IOException {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		List<User> list = sqlSession.selectList("test.findUserInfoByName", "张%");
		sqlSession.close();
		System.err.println(list.size());

	}

	@Test
	public void deleteUserInfoById() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		sqlSession.delete("test.deleteInfoById", 1);
		sqlSession.commit();
		sqlSession.close();
		

	}

	@Test
	public void uuid() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		Uuid uuid = new Uuid();
		uuid.setName("王五");
		sqlSession.insert("uuid.insert", uuid);
		sqlSession.commit();
		sqlSession.close();
		System.err.println(uuid.getId());
	}

	@Test
	public void updateInfoByid() {
		// 获取sqlSession
		SqlSession sqlSession = sessionFactory.openSession();// 默认非自动提交事务
		User user = new User();
		user.setUserName("李三");
		user.setId(10);
		sqlSession.update("test.updateInfoByid", user);
		sqlSession.commit();
		sqlSession.close();

	}

	@Test
	public void query() {
		SqlSession sqlSession = sessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findInfoByName("李%");
		for (User user : list) {
			System.err.println(user.getEmail());
		}

	}

	/**
	 * 通过动态SQL插入用户信息
	 */
	@Test
	public void insertInfo() {
		SqlSession sqlSession = sessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		 User user=new User();
		 user.setCnname("张三");
		 user.setEmail("12345@qq.com");
		 userMapper.save(user);
	}

}
