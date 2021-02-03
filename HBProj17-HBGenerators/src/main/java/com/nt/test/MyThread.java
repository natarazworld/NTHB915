package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class MyThread extends Thread {
	@Override
	public void run() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			tx=ses.beginTransaction();
			 InsurancePolicy policy=new InsurancePolicy();
			 policy.setPolicyName("JA2++"); policy.setCompany("LIC");
			 policy.setTenure(20.0f); 
			 long idVal=(long)ses.save(policy);
			tx.commit();
			System.out.println("Object is saved with id vlaue ::"+idVal);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//run(-)

}//class
