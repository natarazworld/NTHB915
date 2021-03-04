package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			/*	//prepare Query object representing HQL query
				//Query query=ses.createQuery("FROM  com.nt.entity.Employee");
				//Query query=ses.createQuery("FROM  Employee");
				//Query query=ses.createQuery("FROM  Employee  as e");
				//Query query=ses.createQuery("FROM  Employee   e");
				//Query query=ses.createQuery("SELECT  * FROM  Employee ");  //wrong query
				Query query=ses.createQuery("SELECT  e FROM  Employee e ");
				
				//execute  HQL 
				List<Employee> list=query.getResultList();  //or query.list() 
				//process the result
				list.forEach(emp->{
					System.out.println(emp);
				});
				list.forEach(System.out::println);*/
			
			/*  //HQL Select with ordinal positional params
			Query query=ses.createQuery("FROM  Employee WHERE  salary>=?2 and salary<=?1");
			query.setParameter(1, 10000.0f);
			query.setParameter(2, 100000.0f);
			List<Employee> list=query.getResultList();
			list.forEach(System.out::println);*/
			
			/*	  //HQL Select with named  params
				Query query=ses.createQuery("FROM  Employee WHERE eadd IN(:city1,:city2,:city3)");
				query.setParameter("city1", "hyd");
				query.setParameter("city2", "delhi");
				query.setParameter("city3", "vizag");
				List<Employee> list=query.getResultList();
				list.forEach(System.out::println);
				System.out.println("......................");
				
				query.setParameter("city1", "hyd");
				query.setParameter("city2", "delhi");
				query.setParameter("city3", "vizag");
				List<Employee> list1=query.getResultList();
				list1.forEach(System.out::println);
				*/
						
						
			
						/*	//HQL Select with named  params and Lazy Loading
							Query query=ses.createQuery("FROM  Employee WHERE ename LIKE :initChars");
							query.setParameter("initChars", "r%");
							Iterator<Employee> it=query.iterate();
							while(it.hasNext()) {
								Employee emp=it.next();
								System.out.println(emp);
							} */
			
			//HQL supports nested Queries and also aggrate functions
			Query query=ses.createQuery("FROM  Employee   WHERE salary=(SELECT MAX(salary) FROM  Employee)");
			List<Employee> list=query.list();
			list.forEach(System.out::println);
			

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}

	}// main

}// class
