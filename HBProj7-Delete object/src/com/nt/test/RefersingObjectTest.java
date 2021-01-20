//RefreshingTest2.java
package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class RefersingObjectTest {

	public static void main(String[] args) {
		//get SEssion object
		Session ses=HibernateUtil.getSession();
		try {
			//Load object 
			Actor actor=ses.get(Actor.class,1);
			System.out.println(actor);
           System.out.println("--------------------------");
           Thread.sleep(40000);  //during this time modify db table data
           ses.refresh(actor);
           System.out.println(actor);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close Session,SessionFactory object
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
