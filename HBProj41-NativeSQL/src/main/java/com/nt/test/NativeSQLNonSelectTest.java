package com.nt.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeSQLNonSelectTest {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		Transaction tx=null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			/*tx=ses.beginTransaction();
			NativeQuery query=ses.createSQLQuery("UPDATE HQL_EMPLOYEE  SET SALARY=SALARY+ (SALARY*0.1) WHERE EADD=:addrs");
			query.setParameter("addrs","hyd");
			int count=query.executeUpdate();
			System.out.println("no.of records that are updated::"+count);
			tx.commit();*/
			
			tx=ses.beginTransaction();
			NativeQuery query=ses.createSQLQuery("INSERT INTO HQL_EMPLOYEE VALUES(:val1,:val2,:val3,:val4)");
			query.setParameter("val1",9001);
			query.setParameter("val2","ramesh");
			query.setParameter("val3","hyd");
			query.setParameter("val4",6555.677f);
			int count=query.executeUpdate();
			System.out.println("no.of records that are inserted::"+count);
			tx.commit();
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
				tx.rollback();
		}
	}// main
}// class
