package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class JPAQBCTest_Scalar {

	public static void main(String[] args) {
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {

			/*   //create  CriteriaBuilder object  (To get specific multiple col values of DB table)
			   // SELECT ENO,ENAME FROM HQL_EMPLOYEE WHERE  EADD='hyd'
			   CriteriaBuilder builder=ses.getCriteriaBuilder();
			   //create CriteriaQuery object
			   CriteriaQuery ctQuery=builder.createQuery(Object[].class);
			   // Specify Db table /Entity name
			   Root<Employee> root=ctQuery.from(Employee.class);
			   //specify select clause  with col names
			   ctQuery.multiselect(root.get("eno"),root.get("ename"));
			   //specify whre caluse
			   ctQuery.where(builder.equal(root.get("eadd"),"hyd"));
			   //prepare Query object
			   Query query=ses.createQuery(ctQuery);
			   //execute the query
			   List<Object[]> list=query.getResultList();
			   list.forEach(row->{
				   for(Object val:row) {
					   System.out.print(val+"  ");
				   }
				   System.out.println();
			   }); */

			/*// JPA CriteriaQBC to get specific single col value  (Scalar query)
			   // SELECT  ENAME FROM HQL_EMPLOYEE WHERE  SALARY>=100000 AND SALARY<=200000 ORDER BY ENAME DESC
			   //prepare CriteriaBuilder object
			   CriteriaBuilder builder=ses.getCriteriaBuilder();
			   //create CriteriaQuery object
			   CriteriaQuery<Object> ctQuery=builder.createQuery(Object.class);
			   // add from clause pointing to table/Entiy name
			   Root<Employee> root=ctQuery.from(Employee.class);
			   //add select clause specifying the col/property name
			   ctQuery.multiselect(root.get("ename")).where(builder.and(builder.ge(root.get("salary"),100000.0f),
					                                                                                                  builder.le(root.get("salary"), 500000.0f))).orderBy(builder.desc(root.get("ename")));
			   //prepare query object to execute the query
			   Query query=ses.createQuery(ctQuery);
			   List<Object> list=query.getResultList();
				  list.forEach(name->{
				   System.out.println(name);
				  });
			  list.forEach(System.out::println);*/
			
			
			/*	// JPA CriteriaQBC to get aggragate results  (Scalar query)
				   // SELECT  COUNT(*) FROM HQL_EMPLOYEE 
				   //prepare CriteriaBuilder object
				   CriteriaBuilder builder=ses.getCriteriaBuilder();
				   //create CriteriaQuery object
				   CriteriaQuery<Object> ctQuery=builder.createQuery(Object.class);
				   // add from clause pointing to table/Entiy name
				   Root<Employee> root=ctQuery.from(Employee.class);
				   //add select clause specifying the col/property name
				   ctQuery.multiselect(builder.count(root.get("eno")));
				   //prepare query object to execute the query
				   Query query=ses.createQuery(ctQuery);
				   List<Object> list=query.getResultList();
				   System.out.println("Records count::"+list.get(0));*/
			
			/*	// JPA CriteriaQBC to get multiple aggragate results  (Scalar query)
				   // SELECT  COUNT(*),SUM(salary),avg(salary) FROM HQL_EMPLOYEE 
				   //prepare CriteriaBuilder object
				   CriteriaBuilder builder=ses.getCriteriaBuilder();
				   //create CriteriaQuery object
				   CriteriaQuery<Object[]> ctQuery=builder.createQuery(Object[].class);
				   // add from clause pointing to table/Entiy name
				   Root<Employee> root=ctQuery.from(Employee.class);
				   //add select clause specifying the col/property name
				   ctQuery.multiselect(builder.count(root.get("eno")),builder.sum(root.get("salary")),builder.avg(root.get("salary")));
				   //prepare query object to execute the query
				   Query query=ses.createQuery(ctQuery);
				   List<Object[]> list=query.getResultList();
				   Object row[]=list.get(0);
				   System.out.println("records count::"+row[0]);
				   System.out.println("sum of salary::"+row[1]);
				   System.out.println("avg of salary::"+row[2]);*/
			
			
			 // geting  the recrods of  Db table  by applying pagination  
			//  Using  Method chaning concept
				//Create CriteriaBuilder object
				CriteriaBuilder  builder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				CriteriaQuery<Employee> ctQuery=builder.createQuery(Employee.class);
				//specity db table name or Entity name
				Root<Employee > root=ctQuery.from(Employee.class);
				// Sepecify Root object for select operation 
				ctQuery.select(root);
				//prepare Query object to execute the Query
				Query query=ses.createQuery(ctQuery);
				// perform pagination
				query.setFirstResult(8);
				query.setMaxResults(4);
				//execute the query
				List<Employee> list=query.getResultList();
				list.forEach(emp->{
					System.out.println(emp);
				});
			
			   

		} // try
		catch (HibernateException he) {
			he.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// main

}// class
