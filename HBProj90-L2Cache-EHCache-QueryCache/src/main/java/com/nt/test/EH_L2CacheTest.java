package com.nt.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class EH_L2CacheTest {
  
	
	public static void main(String[] args) {
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			//Load record/object
			BankAccount account1=ses.get(BankAccount.class,1001L);  //loads from DB and keeps L2 cache and L1 cache
			System.out.println(account1);
			System.out.println("-----------1-------------");
			BankAccount account2=ses.get(BankAccount.class,1001L);  //Collects L1 cache
			System.out.println(account2);
			System.out.println("-----------2-------------");
			ses.evict(account2); //removes from L1 cache
			System.out.println("-----------3-------------");
			BankAccount account3=ses.get(BankAccount.class,1001L);  //collects from L2 cache and keeps  inL1 cache
			System.out.println(account3);
			System.out.println("-----------4-------------");
			ses.clear(); //removes from L1 cache
			Thread.sleep(15000);  //removes from L2 cache  becoz of idletime out period
			System.out.println("-----------5-------------");
			
			BankAccount account4=ses.get(BankAccount.class,1001L);  //Loads from DB and keeps in L2 cache and L1 cache
			System.out.println(account4);
			System.out.println("-----------6-------------");
			
		}//try
		catch(HibernateException  he) {
			he.printStackTrace();
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		
	}//main
}//class
