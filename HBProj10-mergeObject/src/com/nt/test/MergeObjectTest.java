package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		// Get HB session
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			tx=ses.beginTransaction();
		     //using ses.merge(-) for saveOrUpdate(-) operation
			Actor actor=new Actor();
			actor.setActorId(6794);
			actor.setActorName("kumar");
			actor.setActorAddrs("vizag");
			actor.setPhone(978866644L);
			actor.setRemuneration(9896677.0f);
			ses.merge(actor);
			flag=true;
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
				System.out.println("Object is saved or updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved or updated");
			}
			//close objs
             HibernateUtil.closeSession(ses);
             HibernateUtil.closeSessionFactory();
		}//finally
	}//class
}//class
