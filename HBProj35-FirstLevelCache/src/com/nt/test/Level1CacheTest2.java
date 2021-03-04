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

public class Level1CacheTest2 {

	public static void main(String[] args) {
		//Get HB Session obj
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			//To begin Tx
			tx=ses.beginTransaction();
			   Actor actor=new Actor();
			   actor.setActorName("ntr"); actor.setActorAddrs("hyd");
			   actor.setPhone(674777665L); actor.setRemuneration(345665465.0f);
			   //save object
			   ses.save(actor);
			   System.out.println("11");
			 flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			 //Tx mgmt
			if(flag) {
				System.out.println("22");
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close Session obj (connection closing)
			HibernateUtil.closeSession(ses);
			//close SessionFactory object
			HibernateUtil.closeSessionFactory();
		}//finally   
	
		
		
	}//main
}//class
