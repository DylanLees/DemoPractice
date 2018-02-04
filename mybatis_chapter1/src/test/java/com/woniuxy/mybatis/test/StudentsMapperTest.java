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

import com.woniuxy.mybatis.entity.Health;
import com.woniuxy.mybatis.entity.Student;
import com.woniuxy.mybatis.entity.StudentMapper;

public class StudentsMapperTest {
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
	public void findStudentInfoById() {
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentInfoWithIdCardById(1);
		System.err.println(student.getIdCard().getNatives());

	}

	@Test
	public void findStudentInfoWithHealthById() {
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentInfoWithHealthById(1);
		List<Health> health = student.getHealth();
		for (Health health2 : health) {
			System.err.println(health2.getNote());
		}

	}
	@Test
	public void query() {
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentInfoWithLazyLoadById(1);
		System.err.println("********************************************");
		List<Health> health = student.getHealth();
		for (Health health2 : health) {
			System.err.println(health2.getNote());
		}
		sqlSession.close();
	}
	@Test
	public void query1() {
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentInfoById(1);
		System.err.println(student.getCnname());
		sqlSession.close();

	}
	
}
