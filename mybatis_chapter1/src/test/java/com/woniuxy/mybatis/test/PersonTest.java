package com.woniuxy.mybatis.test;

import com.woniuxy.mybatis.jdk.Bob;
import com.woniuxy.mybatis.jdk.Person;
import com.woniuxy.mybatis.jdk.ProxyFactory;

/**
 * ����
 * 
 * @author Administrator
 *
 */
public class PersonTest {
	public static void main(String[] args) {
		// ���涯̬���ɵ�class�ļ�
		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		// ����Ŀ�����
		Bob bob = new Bob();
		// �Ҵ���
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(bob);
		Person proxy = (Person) factory.createProxy();// ת��ΪPerson�ӿ�
		String buy = proxy.buy("��ʱ��");// �������û��Զ�����invoke��������
		System.out.println(buy);

	}
}
