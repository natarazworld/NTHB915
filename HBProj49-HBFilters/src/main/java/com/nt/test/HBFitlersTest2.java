package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFitlersTest2 {

	public static void main(String[] args) {
		Transaction tx=null;
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			// get Access to filter by enabling filter
			Filter filter1=ses.enableFilter("IGNORE_ACCOUNTS_FILTER");
			//set values to filter parameters
			filter1.setParameter("accountType1", "BLOCKED");
			filter1.setParameter("accountType2", "CLOSED");
			filter1.setParameter("accountType3", "SUSPENDED");
			tx=ses.beginTransaction();
			//prepare and  execute HQL Select qury
			Query query=ses.createQuery("UPDATE BankAccount SET balance=balance+:amount");
			//set query parameter
			query.setParameter("amount",4000.0f);
			//execute the query
			int result=query.executeUpdate();
            System.out.println("no.of reords that are effcted is :;"+result);
            tx.commit();
		}
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()  )
			     tx.rollback();
			he.printStackTrace();
		}
		
	}//main
}//class
