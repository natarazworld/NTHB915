package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest2{

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		Transaction tx=null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			//get Access to named  HQL query1 and execute it 
			Query query1=ses.getNamedQuery("HQL_GET_EMP_DETAILS");
			query1.setParameter("start", 200000.0f);
			query1.setParameter("end", 1000000.0f);
			List<Employee> list=query1.getResultList();
			list.forEach(System.out::println);
			System.out.println("...................................");
			//get Access to named  HQL query2 and execute it
		     tx=ses.beginTransaction();
		     Query query2=ses.getNamedQuery("HQL_SALARY_BONUS");
		     query2.setParameter("bonus", 4000.0f);
		     query2.setParameter("addrs", "hyd");
		     int result=query2.executeUpdate();
		     tx.commit();
		     System.out.println("no.of records that are effected ::"+result);
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null  && tx.getRollbackOnly())
				tx.rollback();
		}

	}// main

}// class
