package com.nt.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SoftDeletionTest {
  
	
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter account number::");
		 long no=sc.nextLong();
		 Transaction tx=null;
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			//Load record/object
			BankAccount account1=ses.get(BankAccount.class,no);
			if(account1!=null) {
			   tx=ses.beginTransaction();
			       ses.delete(account1);
			    tx.commit();
			    System.out.println("account closed");
			}
			else {
				System.out.println("account not found/already closed");
			}
		}//try
		catch(HibernateException  he) {
			he.printStackTrace();
			if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly())
				  tx.rollback();
		}
		
	}//main
}//class
