package com.woniuxy.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Role;
import com.woniuxy.hibernate.entity.User;

public class RoleTest {

	@Test
	public void save() {
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		// ��ӽ�ɫ��Ϣ
		Role role = new Role();
		//���ý�ɫ�����ֵ
		role.setName("��ͨ�û�");
		role.setId(1);
		
		//����һ�����϶���
		Set<User> users=new HashSet<User>();
		User user =new User();
		user.setId(2);
		user.setName("����");
		user.setSex("��");
		users.add(user);
		role.setUsers(users);
		createEntityManager.merge(role);
		// �ύ����
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		createEntityManagerFactory.close();

	}
}
