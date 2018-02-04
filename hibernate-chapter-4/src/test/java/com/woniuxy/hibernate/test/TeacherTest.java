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
		teacher.setName("张老师");
		
		//分配学生---->数据库存在
		Set<Student> students=new HashSet<>();
		Student student=new Student();
		student.setId(2);
		students.add(student);
		//处理和学生的关系--->维系老师和学生的关系
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
		
		//先得到该老师的学生
		teacher.getStudents().clear();//---->持久态:修改属性值之后自动触发update语句
		
		
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
		
		//获取该老师的学生信息
		Set<Student> students = teacher.getStudents();//一对多、多对多 默认都是懒加载
		for (Student student : students) {
			System.out.println(student.getName());
		}
	}
	
	@Test
	public void query(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//创建query对象--->查询teacher表中的数据--->sql--->select *　from　teachers ---> from Teacher
		String jpql="from Teacher";
		Query query = entityManager.createQuery(jpql);
		
		//执行查询
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
		
		//创建query对象--->查询teacher表中的数据--->sql--->select *　from　teachers ---> from Teacher
//		String jpql="from Teacher where id=:tId";//命名参数
		String jpql="from Teacher where id=?";//占位符
		Query query = entityManager.createQuery(jpql);
		
		//绑定数据
//		query.setParameter("tId", 2);//第一个参数参数的名称，第二 数据
		query.setParameter(0, 2);
		
		//执行查询
		Teacher teacher=(Teacher) query.getSingleResult();//返回单条数据
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(teacher.getName());
	}
	
	@Test
	public void query2(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql="from Student where age=:age or name=:name";//默认就是* 所有的属性
		Query query = entityManager.createQuery(jpql);
		
		query.setParameter("age", 21);
		query.setParameter("name", "张三1");
		
		List<Student> students = query.getResultList();//必须执行的全字段查询--->得到所有的属性
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(students.size());
	}
	
	@Test
	public void query3(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql="select name,age from Student where age=:age or name=:name";//只取name属性
		Query query = entityManager.createQuery(jpql);
		
		query.setParameter("age", 21);
		query.setParameter("name", "张三1");
		
		List<Object[]> students = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		for (Object[] student : students) {
			for (Object object : student) {
				System.out.println(object);
			}
		}
	}
	
	//merger--->更新--->全字段更新
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
		
		//注册输入和输出参数，---->必须要在执行之前
		query.registerStoredProcedureParameter(0, Integer.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		
		//绑定数据--->只针对输入的类型参数
		query.setParameter(1, 1);
		
		//执行存储过程
		query.execute();
		
		//获取输出参数的数据
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
		
		query.setParameter(1, "李四");
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
		
		//设置分页的参数
		query.setFirstResult(4);//从什么时候开始取数据--->offset
		query.setMaxResults(4);//取多少条数据		-->size
		
		//执行查询
		List<Teacher> teachers = query.getResultList();*/
		
		//分页
		PageInfo<Teacher> pageInfo=new PageInfo<>();
		pageInfo.setPageNum(2);
		//1.获取总记录条数
		String hql="select count(1) from Teacher";
		Query query = entityManager.createQuery(hql);
		int total = ((Long)query.getSingleResult()).intValue();
		pageInfo.setTotal(total);//计算总页数
		
		//2.分页查询
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
