//JPAQBCTest.java
package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class JPAQBCTest {

	public static void main(String[] args) {
		
		/*
		   // geting all the recrods of  Db table 
		  try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession()){
			//Create CriteriaBuilder object
			CriteriaBuilder  ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Employee> ctQuery=ctBuilder.createQuery(Employee.class);
			//Prepare Object to specify  the from  "DB table/ Entity class name"  // from Employee/HQL_Employee
			Root<Employee > root=ctQuery.from(Employee.class);
			// Sepecify Root object for select operation    // gives "SELECT * FROM HQL_Employee"
			ctQuery.select(root);
			//prepare Query object to execute the Query
			Query query=ses.createQuery(ctQuery);
			//execute the query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*   // geting  the recrods of  Db table  by applying conditions and orderby clauses
		  try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession()){
			//Create CriteriaBuilder object
			CriteriaBuilder  ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Employee> ctQuery=ctBuilder.createQuery(Employee.class);
			//Prepare Object to specify  the from  "DB table/ Entity class name"  // from Employee/HQL_Employee
			Root<Employee > root=ctQuery.from(Employee.class);
			// Sepecify Root object for select operation    // gives "SELECT * FROM HQL_Employee"
			ctQuery.select(root);
			//prepare named Parameters
			ParameterExpression<Integer> param1=ctBuilder.parameter(Integer.class,"start");
			ParameterExpression<Integer> param2=ctBuilder.parameter(Integer.class,"end");
			//prepare conditions having the named parameters 
			Predicate pdc1=ctBuilder.ge(root.get("eno"), param1);  //  gives eno>=:start
			Predicate pdc2=ctBuilder.le(root.get("eno"), param2);  //gives  eno<=:end
			Predicate pdc3=ctBuilder.and(pdc1,pdc2);  //gvies   eno>=:start and eno<=:end
			ctQuery.where(pdc3);  //  SELECT * FROM HQL_EMPLOYEE WHERE ENO>=:start AND ENO<=:end
			//add Order 
			Order order=ctBuilder.desc(root.get("ename"));
			ctQuery.orderBy(order);
			//prepare Query object to execute the Query
			Query query=ses.createQuery(ctQuery);
			//set values to params
			query.setParameter("start",1000);
			query.setParameter("end",3000);
			//execute the query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
	/*	   // geting  the recrods of  Db table  by applying conditions and orderby clauses  
		//  Using  Method chaning concept
		  try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession()){
			//Create CriteriaBuilder object
			CriteriaBuilder  ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Employee> ctQuery=ctBuilder.createQuery(Employee.class);
			//Prepare Object to specify  the from  "DB table/ Entity class name"  // from Employee/HQL_Employee
			Root<Employee > root=ctQuery.from(Employee.class);
			// Sepecify Root object for select operation    // gives "SELECT * FROM HQL_Employee where eno>=1000 and eno<=2000 order by ename "
			ctQuery.select(root).where(ctBuilder.and(ctBuilder.ge(root.get("eno"),1000),
					                                                                 ctBuilder.le(root.get("eno"),2000)      
					                                                                )).orderBy(ctBuilder.desc(root.get("ename")));
			//prepare Query object to execute the Query
			Query query=ses.createQuery(ctQuery);
			//execute the query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		} */
		
		
		/* // geting  the recrods of  Db table  by applying conditions and orderby clauses  
		 //  select * from HQL_Employee where eadd in('hyd','vizag') order by eadd
		//  Using  Method chaning concept
		  try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession()){
			//Create CriteriaBuilder object
			CriteriaBuilder  ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Employee> ctQuery=ctBuilder.createQuery(Employee.class);
			//Prepare Object to specify  the from  "DB table/ Entity class name"  // from Employee/HQL_Employee
			Root<Employee > root=ctQuery.from(Employee.class);
			// Sepecify Root object for select operation    // gives "SELECT * FROM HQL_Employee where eno>=1000 and eno<=2000 order by ename "
			ctQuery.select(root).where(root.get("eadd").in("hyd","vizag")).orderBy(ctBuilder.desc(root.get("eadd")));
			//prepare Query object to execute the Query
			Query query=ses.createQuery(ctQuery);
			//execute the query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});*/
		
		
		/* // geting  the recrods of  Db table  by applying conditions and orderby clauses  
		 //  select * from HQL_Employee where ename like 'r%'
		//  Using  Method chaning concept
		  try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession()){
			//Create CriteriaBuilder object
			CriteriaBuilder  ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Employee> ctQuery=ctBuilder.createQuery(Employee.class);
			//Prepare Object to specify  the from  "DB table/ Entity class name"  // from Employee/HQL_Employee
			Root<Employee > root=ctQuery.from(Employee.class);
			// Sepecify Root object for select operation    // gives "SELECT * FROM HQL_Employee where ename like 'r%'
			ctQuery.select(root).where(ctBuilder.like(root.get("ename"),"r%"));
			//prepare Query object to execute the Query
			Query query=ses.createQuery(ctQuery);
			//execute the query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});*/
			
			 // geting  the recrods of  Db table  by applying conditions and orderby clauses  
			 //  select * from HQL_Employee where ename like 'r___'
			//  Using  Method chaning concept
			  try(SessionFactory factory=HibernateUtil.getSessionFactory();
					Session ses=HibernateUtil.getSession()){
				//Create CriteriaBuilder object
				CriteriaBuilder  ctBuilder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				CriteriaQuery<Employee> ctQuery=ctBuilder.createQuery(Employee.class);
				//Prepare Object to specify  the from  "DB table/ Entity class name"  // from Employee/HQL_Employee
				Root<Employee > root=ctQuery.from(Employee.class);
				// Sepecify Root object for select operation    // gives "SELECT * FROM HQL_Employee where ename like 'r___'
				ctQuery.select(root).where(ctBuilder.like(root.get("ename"),"r___"));
				//prepare Query object to execute the Query
				Query query=ses.createQuery(ctQuery);
				//execute the query
				List<Employee> list=query.getResultList();
				list.forEach(emp->{
					System.out.println(emp);
				});
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		
				
	}// main
}// class
