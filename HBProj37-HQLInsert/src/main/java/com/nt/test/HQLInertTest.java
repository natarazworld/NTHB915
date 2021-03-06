package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class HQLInertTest {

	public static void main(String[] args) {
		
		Transaction tx=null;
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=factory.openSession()	){
			//begin tx
			tx=ses.beginTransaction();
			//prepare` and execute HQL INSERT Query
			Query query=ses.createQuery("INSERT INTO  NGOMember(mid,ename,eadd,salary)    SELECT e.eno,e.ename,e.eadd,e.salary   FROM Employee as  e  where  e.salary>=:sal ");
			query.setParameter("sal", 400000.0f);
			int count=query.executeUpdate();
			System.out.println("no.of records that are  transffered:: "+count);
			tx.commit();
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true)
				tx.rollback();
		}//catch(-,-)
		

	}//main
}//class
