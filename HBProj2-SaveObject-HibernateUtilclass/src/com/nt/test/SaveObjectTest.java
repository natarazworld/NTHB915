//SaveObjectTest.java
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

public class SaveObjectTest {

	public static void main(String[] args) {
		System.out.println("main(-) method");
		try {
		Class.forName("com.nt.utility.HibernateUtil");
		}
		catch(Exception e) {
			e.getSuppressed();
		}
		//Get HB Session obj
		Session ses=HibernateUtil.getSession();
		//prepare Entity class object
	Actor actor=new Actor();
		//actor.setActorName("katrina9");
		actor.setRemuneration(9115566.0f);
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			tx=ses.beginTransaction(); //  internally calls  con.setAutoCommit(false) 
			//execute logics
			 int idVal=(int)ses.save(actor);
			 System.out.println("Generated idvalue::"+idVal);
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
			if(flag) {
				tx.commit();  //iternally calls con.commit() method
				System.out.println("Object is saved -- Object data is inserted to DB table as record");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved -- Object data is not inserted to the DB table as record");
			}
			//close Session obj (connection closing)
			HibernateUtil.closeSession(ses);
			//close SessionFactory object
			HibernateUtil.closeSessionFactory();
		}//finally   
	
		
		
	}//main
}//class
