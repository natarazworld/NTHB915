//DeleteObjectTest
package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest1 {

	public static void main(String[] args) {
		//get SEssion object
		Session ses=HibernateUtil.getSession();
		//load the object
		Actor actor=ses.get(Actor.class, 1);
		if(actor!=null) {
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			tx=ses.beginTransaction();
			 ses.delete(actor);
			flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			//perfrom  Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Object is deleted");
			}
			else {
				tx.rollback();
				System.out.println("Object is not deleted");
			}
			//close Session,SessionFactory object
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		}
		else {
			System.out.println("record not found");
			//close Session,SessionFactory object
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
