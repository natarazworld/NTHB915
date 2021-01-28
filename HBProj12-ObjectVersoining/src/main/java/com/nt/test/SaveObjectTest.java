package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Transaction tx=null;
		//get SessionFactory
		try(SessionFactory factory=HibernateUtil.getSessionFactory()){
			//get Session
			try(Session ses=factory.openSession()){
				tx=ses.beginTransaction();
				//save object
				CallerTune tune1=new CallerTune();
				tune1.setCallerTune("DIL Mile");
				tune1.setMobileNo(8889999999L);
				tune1.setProvider("jio");
				int idVal=(int)ses.save(tune1);
				tx.commit();
				System.out.println("Object is saved");
			}//try
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved");
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved");
		}

	}//main
}//class
