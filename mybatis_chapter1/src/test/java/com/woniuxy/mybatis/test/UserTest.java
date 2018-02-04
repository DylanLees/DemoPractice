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
		user.setUserName("oldsix");
		// �����û�����
		sqlSession.insert("test.insert", user);// "test.insert"��namespace+id���
		sqlSession.commit();
		sqlSession.close();
		System.err.println(user.getId());

	}

	@Test
	public void findUserInfoById() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		Object object = sqlSession.selectOne("test.findUserInfoById", 10);
		User user = (User) object;
		sqlSession.close();
		System.err.println(user.getCnname());

	}

	@Test
	public void findUserInfoByName() throws IOException {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		List<User> list = sqlSession.selectList("test.findUserInfoByName", "��%");
		sqlSession.close();
		System.err.println(list.size());

	}

	@Test
	public void deleteUserInfoById() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		sqlSession.delete("test.deleteInfoById", 1);
		sqlSession.commit();
		sqlSession.close();
		

	}

	@Test
	public void uuid() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		Uuid uuid = new Uuid();
		uuid.setName("����");
		sqlSession.insert("uuid.insert", uuid);
		sqlSession.commit();
		sqlSession.close();
		System.err.println(uuid.getId());
	}

	@Test
	public void updateInfoByid() {
		// ��ȡsqlSession
		SqlSession sqlSession = sessionFactory.openSession();// Ĭ�Ϸ��Զ��ύ����
		User user = new User();
		user.setUserName("����");
		user.setId(10);
		sqlSession.update("test.updateInfoByid", user);
		sqlSession.commit();
		sqlSession.close();

	}

	@Test
	public void query() {
		SqlSession sqlSession = sessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findInfoByName("��%");
		for (User user : list) {
			System.err.println(user.getEmail());
		}

	}

	/**
	 * ͨ����̬SQL�����û���Ϣ
	 */
	@Test
	public void insertInfo() {
		SqlSession sqlSession = sessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		 User user=new User();
		 user.setCnname("����");
		 user.setEmail("12345@qq.com");
		 userMapper.save(user);
	}

}
