package com.woniuxy.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.woniuxy.mybatis.entity.Uuid;

public class UuidTest {
	/**
	 * ����uuid������
	 */
	@Test
	public void save(){
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
			Uuid uuid=new Uuid();
			uuid.setName("lisiguang");
			sqlSession.insert("uuid.save", uuid);
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
