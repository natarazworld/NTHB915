package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class PaginationPOC{

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			//get Access to named  HQL query1 and execute it 
			Query query=ses.createQuery("FROM Employee");
			query.setFirstResult(6); query.setMaxResults(3);
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}

	}// main

}// class
