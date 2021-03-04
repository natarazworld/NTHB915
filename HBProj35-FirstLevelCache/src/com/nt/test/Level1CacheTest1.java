//LoadObjectTest1.java
package com.nt.test;

import java.util.Arrays;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class Level1CacheTest1 {

	public static void main(String[] args) {
		//Get HB Session obj
		Session ses=HibernateUtil.getSession();
		try {
			Actor actor=ses.get(Actor.class,1);  //Collects form DB and keeps L1 cache
			System.out.println(actor);
			System.out.println("..................................");
			Actor actor1=ses.get(Actor.class,1); //collects from L1 cache
			System.out.println(actor1);
			System.out.println("..................................");
			//ses.evict(actor); //removes actor obj from L1 cache
			//ses.clear();
			Actor actor2=ses.get(Actor.class,1); //Collects form DB and keeps L1 cache
			System.out.println(actor2);
			
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close Session obj (connection closing)
			HibernateUtil.closeSession(ses);
			//close SessionFactory object
			HibernateUtil.closeSessionFactory();
		}//finally   
	
		
		
	}//main
}//class
