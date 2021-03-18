package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class JPAQBCTest_Update {

	public static void main(String[] args) {
		Transaction tx=null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
           
			tx=ses.beginTransaction();
			//UPDATE HQL_EMPLOYEE SET SALARY=700000 WHERE EADD='hyd' 
		//create CriteriaBuilder object
			CriteriaBuilder builder=ses.getCriteriaBuilder();
		//create CriteriaUpdate object
			CriteriaUpdate<Employee> ctUpdate=builder.createCriteriaUpdate(Employee.class);
			//specify from db table/entity
			Root<Employee>  root=ctUpdate.from(Employee.class);
			//modify col value
			ctUpdate.set("salary", 700000.0f).where(builder.equal(root.get("eadd"),"hyd"));
			//prepare query objeect
			Query query=ses.createQuery(ctUpdate);
			//execute the query
			int result=query.executeUpdate();
			System.out.println("no.of records effected"+result);
			tx.commit();
			
		} // try
		catch (HibernateException he) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			tx.rollback();
			  System.out.println("recrods e not updated");
			}
		
			he.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// main

}// class
