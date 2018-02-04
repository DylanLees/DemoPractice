package com.woniuxy.hibernate.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.junit.Test;

import com.woniuxy.hibernate.entity.PageInfo;
import com.woniuxy.hibernate.entity.Student;
import com.woniuxy.hibernate.entity.Teacher;

public class TeacherTest {

	@Test
	public void save(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Teacher teacher=new Teacher();
		teacher.setName("����ʦ");
		
		//����ѧ��---->���ݿ����
		Set<Student> students=new HashSet<>();
		Student student=new Student();
		student.setId(2);
		students.add(student);
		//�����ѧ���Ĺ�ϵ--->άϵ��ʦ��ѧ���Ĺ�ϵ
		teacher.setStudents(students);
		
		entityManager.merge(teacher);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void delele(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Teacher teacher = entityManager.find(Teacher.class, 2);
		
		//�ȵõ�����ʦ��ѧ��
		teacher.getStudents().clear();//---->�־�̬:�޸�����ֵ֮���Զ�����update���
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void find(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Teacher teacher = entityManager.find(Teacher.class, 2);
		
		entityManager.close();
		entityManagerFactory.close();
		
		//��ȡ����ʦ��ѧ����Ϣ
		Set<Student> students = teacher.getStudents();//һ�Զࡢ��Զ� Ĭ�϶���������
		for (Student student : students) {
			System.out.println(student.getName());
		}
	}
	
	@Test
	public void query(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//����query����--->��ѯteacher���е�����--->sql--->select *��from��teachers ---> from Teacher
		String jpql="from Teacher";
		Query query = entityManager.createQuery(jpql);
		
		//ִ�в�ѯ
		List<Teacher> teachers = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
		}
	}
	
	@Test
	public void queryById(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//����query����--->��ѯteacher���е�����--->sql--->select *��from��teachers ---> from Teacher
//		String jpql="from Teacher where id=:tId";//��������
		String jpql="from Teacher where id=?";//ռλ��
		Query query = entityManager.createQuery(jpql);
		
		//������
//		query.setParameter("tId", 2);//��һ���������������ƣ��ڶ� ����
		query.setParameter(0, 2);
		
		//ִ�в�ѯ
		Teacher teacher=(Teacher) query.getSingleResult();//���ص�������
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(teacher.getName());
	}
	
	@Test
	public void query2(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql="from Student where age=:age or name=:name";//Ĭ�Ͼ���* ���е�����
		Query query = entityManager.createQuery(jpql);
		
		query.setParameter("age", 21);
		query.setParameter("name", "����1");
		
		List<Student> students = query.getResultList();//����ִ�е�ȫ�ֶβ�ѯ--->�õ����е�����
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(students.size());
	}
	
	@Test
	public void query3(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql="select name,age from Student where age=:age or name=:name";//ֻȡname����
		Query query = entityManager.createQuery(jpql);
		
		query.setParameter("age", 21);
		query.setParameter("name", "����1");
		
		List<Object[]> students = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		for (Object[] student : students) {
			for (Object object : student) {
				System.out.println(object);
			}
		}
	}
	
	//merger--->����--->ȫ�ֶθ���
	@Test
	public void query4(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String hql="update Teacher set tel=? where id=?";
		Query query = entityManager.createQuery(hql);
		
		query.setParameter(0, "110");
		query.setParameter(1, 2);
		
		query.executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void query5(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String hql="select count(1) from Teacher";
		Query query = entityManager.createQuery(hql);
		
		Long count=(Long) query.getSingleResult();
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(count.intValue());
	}
	
	@Test
	public void procedure(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("countTeachers");
		
		//ע����������������---->����Ҫ��ִ��֮ǰ
		query.registerStoredProcedureParameter(0, Integer.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		
		//������--->ֻ�����������Ͳ���
		query.setParameter(1, 1);
		
		//ִ�д洢����
		query.execute();
		
		//��ȡ�������������
		Object outputParameterValue = query.getOutputParameterValue(0);
		
		System.out.println(outputParameterValue);
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void nativeQuery(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String sql="insert INTO teachers(name,tel)VALUES(?,?)";
		Query query = entityManager.createNativeQuery(sql);
		
		query.setParameter(1, "����");
		query.setParameter(2, "120");
		
		query.executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void nativeQuery1(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String sql="SELECT * from teachers";
		Query query = entityManager.createNativeQuery(sql);
		
		List<Teacher> teachers = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
		}
	}
	
	@Test
	public void queryPage(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		/*
		String hql="from Teacher";
		Query query = entityManager.createQuery(hql);
		
		//���÷�ҳ�Ĳ���
		query.setFirstResult(4);//��ʲôʱ��ʼȡ����--->offset
		query.setMaxResults(4);//ȡ����������		-->size
		
		//ִ�в�ѯ
		List<Teacher> teachers = query.getResultList();*/
		
		//��ҳ
		PageInfo<Teacher> pageInfo=new PageInfo<>();
		pageInfo.setPageNum(2);
		//1.��ȡ�ܼ�¼����
		String hql="select count(1) from Teacher";
		Query query = entityManager.createQuery(hql);
		int total = ((Long)query.getSingleResult()).intValue();
		pageInfo.setTotal(total);//������ҳ��
		
		//2.��ҳ��ѯ
		hql="from Teacher";
		query = entityManager.createQuery(hql);
		query.setFirstResult(pageInfo.getFirstResult());
		query.setMaxResults(pageInfo.getMaxResult());
		
		pageInfo.setDatas(query.getResultList());
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(pageInfo);
		System.out.println(pageInfo.getDatas().size());
	}
	
}
