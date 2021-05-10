package com.nt.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class QeueryCacheTest {
  
	
	public static void main(String[] args) {
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			
			Query query=ses.createQuery("from BankAccount");
			query.setCacheable(true);
			List<BankAccount> list=query.getResultList();
			list.forEach(acc->{
				System.out.println(acc);
			});
			System.out.println("......................");
			List<BankAccount> list1=query.getResultList();
			list1.forEach(acc->{
				System.out.println(acc);
			});
			
			
		}//try
		catch(HibernateException  he) {
			he.printStackTrace();
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		
	}//main
}//class
