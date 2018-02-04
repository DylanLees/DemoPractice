package com.woniuxy.hibernate.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static EntityManagerFactory managerfactory;
	
	public static EntityManagerFactory entityManagerFactory(){
		if(managerfactory==null){			//˫�طǿռ���--->�̰߳�ȫ
			synchronized (JpaUtils.class) {
				if(managerfactory==null){
					managerfactory=Persistence.createEntityManagerFactory("jpa");
				}
			}
		}
		return managerfactory;
	}
	
}
