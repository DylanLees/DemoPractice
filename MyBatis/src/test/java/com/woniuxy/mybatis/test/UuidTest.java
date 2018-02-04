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
	 * 插入uuid的主键
	 */
	@Test
	public void save(){
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
			Uuid uuid=new Uuid();
			uuid.setName("lisiguang");
			sqlSession.insert("uuid.save", uuid);
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
