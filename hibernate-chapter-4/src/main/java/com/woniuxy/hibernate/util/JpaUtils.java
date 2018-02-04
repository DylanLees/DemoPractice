package com.woniuxy.hibernate.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static EntityManagerFactory managerfactory;
	
	public static EntityManagerFactory entityManagerFactory(){
		if(managerfactory==null){			//双重非空加锁--->线程安全
			synchronized (JpaUtils.class) {
				if(managerfactory==null){
					managerfactory=Persistence.createEntityManagerFactory("jpa");
				}
			}
		}
		return managerfactory;
	}
	
}
