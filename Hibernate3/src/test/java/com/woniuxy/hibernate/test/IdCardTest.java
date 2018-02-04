package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.IdCard;
import com.woniuxy.hibernate.entity.User;

public class IdCardTest {
	@Test
	public void save(){
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		//����ʵ�������
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		//����û���Ϣ
		IdCard idCard=new IdCard();
		User user=new User();
		idCard.setNumber("532125198706254874");
		user.setName("heheh");
		//����ʵ����������������persist��������merge�����洢���ݵ����ݿ��С�
		createEntityManager.persist(user);
		createEntityManager.persist(idCard);
		//�ύ����
		createEntityManager.getTransaction().commit();
		//�ر�ʵ����������ͷ���Դ��
		createEntityManager.close();
	}
}
