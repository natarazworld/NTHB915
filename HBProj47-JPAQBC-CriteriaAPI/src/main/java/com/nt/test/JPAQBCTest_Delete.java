package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class JPAQBCTest_Delete {

	public static void main(String[] args) {
		Transaction tx=null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			
           tx=ses.beginTransaction();
		//create CriteriaBuilder object
           //DELETE FROM HQL_EMPLOYEE where EADD='hyd' 
			CriteriaBuilder builder=ses.getCriteriaBuilder();
		//create CriteriaDelete object
			CriteriaDelete<Employee> ctDelete=builder.createCriteriaDelete(Employee.class);
			//specify from db table/entity
			Root<Employee>  root=ctDelete.from(Employee.class);
			//modify col value
			ctDelete.where(builder.equal(root.get("eadd"),"hyd"));
			//prepare query objeect
			Query query=ses.createQuery(ctDelete);
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
