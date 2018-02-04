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

	// ��ȡbuilder
	private SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	private SqlSessionFactory sessionFactory;

	@Before
	public void before() {
		// ���������ļ�
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			// ��ȡsessionFactory
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
	 * �����û���Ϣ
	 */
	@Test
	public void save() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		User user = new User();
		user.setCnname("����");
		user.setEmail("12345");
		user.setMobile("123458799");
		user.setNote("��ţѧԺ");
		user.setSex(1);
		user.setUserName("����");
		// �����û�����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.save(user);
		sqlSession.commit();
		sqlSession.close();
		System.err.println(user.getId());

	}

	/**
	 * ͨ���û�id��ѯ�û���Ϣ
	 */
	@Test
	public void findUserInfoById() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findInfoById(2);
		System.err.println(user.getCnname());
		sqlSession.close();
	}

	/**
	 * ͨ���û�����ѯ�û���Ϣ
	 * 
	 * @throws IOException
	 */
	@Test
	public void findUserInfoByName() throws IOException {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> infoByName = (List<User>) userMapper.findInfoByName("��%");
		for (User user : infoByName) {
			
			System.err.println(user.getCnname());
		}
		sqlSession.close();

	}

	/**
	 * ͨ���û�idɾ���û���Ϣ
	 */
	@Test
	public void deleteUserInfoById() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.delete(2);
		sqlSession.commit();
		sqlSession.close();

	}

	/**
	 * �����û���Ϣ
	 */

	@Test
	public void updateInfoByid() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUserName("����");
		user.setId(11);
		userMapper.update(user);
		sqlSession.commit();
		sqlSession.close();

	}

}
