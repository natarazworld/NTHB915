package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		
		// Get HB session
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			tx=ses.beginTransaction();
			//Load object
			Actor actor=ses.get(Actor.class, 20); //collects from DB and keeps first Level cache
			if(actor!=null)
				System.out.println(actor);
			//update loaded object by creating new object having same id 
			Actor actor1=new Actor();
			actor1.setActorId(20);
			actor1.setActorName("amitab");
			actor1.setActorAddrs("vizag1");
			actor1.setPhone(9899999L);
			actor1.setRemuneration(7896566.0f);
				Actor actor2=(Actor) ses.merge(actor1);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			  //peform TxMgmt
			   if(flag) {
				   tx.commit();
			     System.out.println("Object is merged"); 
			     } 
			   else { 
				   tx.rollback();
			    System.out.println("Object is not merged"); 
			  }
			 
			//close objs
             HibernateUtil.closeSession(ses);
             HibernateUtil.closeSessionFactory();
		}//finally
	}//class
}//class
