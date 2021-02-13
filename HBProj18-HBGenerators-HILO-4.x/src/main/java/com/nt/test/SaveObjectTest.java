package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
	   // GEt SessionFactory object
		Transaction tx=null;
		SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session ses=HibernateUtil.getSession();
		  try {
		           tx=ses.beginTransaction();
		            //save object 
		            InsurancePolicy policy=new InsurancePolicy();
		              policy.setPolicyName("JA++");
		            policy.setCompany("Axis"); policy.setTenure(25.0f);
		            long idVal=(long)ses.save(policy);
		            System.out.println("Generated id value ::"+idVal);
	    	     tx.commit();
		    	     System.out.println("Objects saved with idvals::"+idVal);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Object is not saved");
		}
		  finally {
			  HibernateUtil.closeSession(ses);
			  HibernateUtil.closeSessionFactory();
		  }
		

	}//main
}//class
