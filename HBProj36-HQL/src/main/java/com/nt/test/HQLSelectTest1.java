package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest1 {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			/*	//Executing HQL Select Query that gives specific multiple col values  (scalar queries)
				   Query query=ses.createQuery("SELECT  eno,ename  from  Employee where  ename like '____' ");
				    List<Object[]> list=query.getResultList();
				    list.forEach(row->{
				    	for(Object val:row) {
				    		System.out.print(val+"  ");
				    	}
				    	System.out.println();
				    });
			*/	  //Executing HQL Select Query that gives single  col value  (scalar queries)
			/*Query query=ses.createQuery("SELECT  salary  FROM  Employee  WHERE  eadd=:addrs ");
			query.setParameter("addrs", "hyd");
			List<Float> list=query.getResultList();
			//list.forEach(sal-> System.out.println(sal));
			   list.forEach(System.out::println);
			*/	
			
			/*	//Query query=ses.createQuery("  FROM  Employee  WHERE  eno>=:start and eno<=?0 ");
				Query query=ses.createQuery("  FROM  Employee  WHERE  eno>=?0 and eno<=:end");
				query.setParameter(0, 1000);
				query.setParameter("end", 2000);
				List<Employee> list=query.getResultList();
				   list.forEach(System.out::println);*/
			
			/*//Executing HQL Select Query that is using single aggregate function
			  Query query=ses.createQuery("SELECT COUNT(*)  FROM Employee");
			  List<Long> list=query.getResultList();
			  System.out.println("records count::"+list.get(0));*/
			  
			/*//Executing HQL Select Query that is using multiple aggregate functions
			  Query query=ses.createQuery("SELECT COUNT(*),MAX(salary),MIN(salary),AVG(salary),SUM(salary)  FROM Employee");
			  List<Object[]> list=query.getResultList();
			  Object row[]=list.get(0);
			  System.out.println("records count::"+row[0]);
			  System.out.println("Max salary ::"+row[1]);
			  System.out.println("Min salary ::"+row[2]);
			  System.out.println("Avg salary ::"+row[3]);
			  System.out.println("sum of salaries ::"+row[4]);*/
			
			
				//Executing HQL Select Query that gives specific multiple col values  (scalar queries)
			   Query query=ses.createQuery("SELECT  eno,ename  from  Employee where  ename like '____' ");
			    Iterator<Object[]> it=query.iterate();
				while(it.hasNext()) {
					Object row[]=it.next();
					for(Object val:row) {
						System.out.print(val+"  ");
					}
					System.out.println();
				}//while
							  
		
			
			

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}

	}// main

}// class
