//SaveOrUpdateTest
package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
		//get SEssion object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  //Save or update object
			Actor actor=new Actor();
			actor.setActorId(6795);
			 actor.setActorName("rajesh");
			actor.setActorAddrs("hyd18"); actor.setPhone(900998L);
			actor.setRemuneration(8900666.0f);
			ses.saveOrUpdate(actor);
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
				System.out.println("Object is saved or updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved or  updated");
			}
			//close Session,SessionFactory object
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
