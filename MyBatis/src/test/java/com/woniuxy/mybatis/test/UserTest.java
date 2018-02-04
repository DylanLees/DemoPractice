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
	 * ͨ��id��ѯ�û���Ϣ
	 */
	@Test
	public void findUserById(){
		try {
			//���������ļ�
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//�������ģʽ,�������Ӷ���
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//����sqlSessionFactory����
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//����sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * ��һ������ִ��sql����id namespace+id
			 * �ڶ�������ִ��sql�����β�
			 */
			//��ѯһ�����
			User user=sqlSession.selectOne("test.findUserById", 1);
			//�ر�sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
			System.out.println(user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ͨ���û�����ѯ�û���Ϣ
	 */
	@Test
	public void findUserByCnname(){
		try {
			//���������ļ�
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//�������ģʽ,�������Ӷ���
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//����sqlSessionFactory����
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//����sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * ��һ������ִ��sql����id namespace+id
			 * �ڶ�������ִ��sql�����β�
			 */
			//��ѯһ�����
			List<User> user= sqlSession.selectList("test.findUserByCnname", "��%");
			//�ر�sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
			System.out.println(user.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ɾ���û���Ϣ
	 */
	@Test
	public void deleteUserById(){
		try {
			//���������ļ�
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//�������ģʽ,�������Ӷ���
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//����sqlSessionFactory����
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//����sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * ��һ������ִ��sql����id namespace+id
			 * �ڶ�������ִ��sql�����β�
			 */
			//ɾ���û���Ϣ
			sqlSession.delete("test.deleteUserById", 2);
			//�ύ����
			sqlSession.commit();
			//�ر�sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����û���Ϣ
	 */
	@Test
	public void update(){
		try {
			//���������ļ�
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//�������ģʽ,�������Ӷ���
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//����sqlSessionFactory����
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//����sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * ��һ������ִ��sql����id namespace+id
			 * �ڶ�������ִ��sql�����β�
			 */
			//�����û���Ϣ
			User user=new User();
			user.setCnname("����");
			user.setId(1);
			sqlSession.update("test.update", user);
			//�ύ����
			sqlSession.commit();
			//�ر�sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����û���Ϣ
	 * 
	 */
	@Test
	public void insert(){
		try {
			//���������ļ�
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//�������ģʽ,�������Ӷ���
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//����sqlSessionFactory����
			SqlSessionFactory sqlSessionFactory=builder.build(is);
			//����sqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			/**
			 * ��һ������ִ��sql����id namespace+id
			 * �ڶ�������ִ��sql�����β�
			 */
			//�����û���Ϣ
			User user=new User();
			user.setUser_name("zhangang");
			user.setCnname("�Ű�");
			user.setSex(1);
			user.setEmail("zhaoliu@woniuxy.com");
			user.setMobile("112");
			user.setNote("��ţѧԺ");
			sqlSession.insert("test.insert", user);
			//�ύ����
			sqlSession.commit();
			//�ر�sqlSession
			sqlSession.close();
			sqlSessionFactory=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
