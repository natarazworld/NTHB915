package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtil_MySql;
import com.nt.util.HibernateUtil_Oracle;

public class TransferRecordTest {

	public static void main(String[] args) {
		
		Transaction tx=null;
		try(SessionFactory oraFactory=HibernateUtil_Oracle.getSessionFactory();
				SessionFactory mysqFactory=HibernateUtil_MySql.getSessionFactory()){
			try(Session oraSes=HibernateUtil_Oracle.getSession(); 
					Session mysqlSes=HibernateUtil_MySql.getSession()){
				        tx=mysqlSes.beginTransaction();
				          //Load object /record from oracle
				        InsurancePolicy policy=oraSes.get(InsurancePolicy.class,9002L);
				         if(policy==null) {
				        	 System.out.println("record not found");
				        	 return;
				         }
				         else {
				        	 //save object to mysql
				        	 mysqlSes.save(policy);
				        	 tx.commit();
				        	 System.out.println("record/object is transfffered");
				         }
			}//try2
		}//try1
		catch(HibernateException he) {
			if(tx!=null  && tx.getStatus()!=null  && tx.getRollbackOnly())
				  tx.rollback();
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
