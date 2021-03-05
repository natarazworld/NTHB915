package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLNonSelectTest2 {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		Transaction tx=null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
	     tx=ses.beginTransaction();
	       //executing HQL Update query
	     Query query=ses.createQuery("UPDATE  Employee  SET salary=salary+:bonus WHERE salary<=:range");
	     query.setParameter("bonus", 4000.0f);
	     query.setParameter("range", 50000.0f);
	     int count=query.executeUpdate();
	     System.out.println("no.of records that are effected:::"+count);
			tx.commit();
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true)
			tx.rollback();
		}

	}// main

}// class
