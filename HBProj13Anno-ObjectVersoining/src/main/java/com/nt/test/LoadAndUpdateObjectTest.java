package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HibernateUtil;

public class LoadAndUpdateObjectTest {

	public static void main(String[] args) {
		Transaction tx=null;
		//get SessionFactory
		try(SessionFactory factory=HibernateUtil.getSessionFactory()){
					//get Session
				try(Session ses=factory.openSession()){
					tx=ses.beginTransaction();
					//Load object
					CallerTune tune=ses.get(CallerTune.class,21);
					if(tune==null) {
						System.out.println("Object/record not found");
						return;
					}
					//modify object
					//tune.setCallerTune("airtel music");
					tune.setProvider("vi");
					tx.commit();
					System.out.println("Object is updated for    "+tune.getChangeCount()+"   times");
				}//try
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not updated");
		}
		catch(Exception e) {
			 e.printStackTrace();
				tx.rollback();
				System.out.println("Object is not updated");
		}

	}//main
}//class
