//SaveObjectTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Actor;

public class SaveObjectTest {

	public static void main(String[] args) throws Exception{
		//Bootstrap the Hibernate  (Activate HB f/w)
		Configuration cfg=new Configuration();
	//Specify the name and location of HB cfg file (indirectly  mapping file )
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		// create  HB SessionFactory object
		SessionFactory factory=cfg.buildSessionFactory();
		Thread.sleep(20000);
		//create HB Session obj
		Session ses=factory.openSession();
		//prepare Entity class object
	Actor actor=new Actor();
		actor.setActorId(920); 
		actor.setActorName("ranveer3");
		actor.setActorAddrs("mumbai"); actor.setPhone(3252634555L); 
		actor.setRemuneration(13556.0f);
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
				Thread.sleep(20000);
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved -- Object data is not inserted to the DB table as record");
			}
			//close Session obj (connection closing)
			ses.close();
			//close SessionFactory object
			factory.close();
		}//finally  
		
	}//main
}//class
