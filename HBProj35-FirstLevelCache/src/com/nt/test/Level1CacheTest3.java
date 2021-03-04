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

public class Level1CacheTest3 {

	public static void main(String[] args) {
		//Get HB Session obj
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			tx=ses.beginTransaction();
			//Load object
			Actor actor=ses.get(Actor.class,1);  //Collects form DB and keeps L1 cache
			System.out.println(actor);
			//update1
		   actor.setRemuneration(534543535.0f);
		   ses.update(actor);
		   //update2
		   actor.setPhone(111111L);
           flag=true;			
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			 //Tx mgmt
			if(flag) {
				System.out.println("22");
				tx.commit();
				System.out.println("Object is updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not updated");
			}
			//close Session obj (connection closing)
			HibernateUtil.closeSession(ses);
			//close SessionFactory object
			HibernateUtil.closeSessionFactory();
		}//finally   
	
		
		
	}//main
}//class
