//ProcedureCallTest.java 
package com.nt.test;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;

import com.nt.utility.HibernateUtil;

public class ProcedureCallTest {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			//create StoredProcedure object having Pl/SQL Procedure name
			ProcedureCall  procedure=ses.createStoredProcedureCall("P_AUTHENTICATION");
			//bind parameters
			procedure.registerParameter("UNAME",String.class,ParameterMode.IN).bindValue("raja");;
			procedure.registerParameter("PASS",String.class,ParameterMode.IN).bindValue("rani1");;
			procedure.registerParameter("RESULT",String.class,ParameterMode.OUT);
			//call PL/SQL proecdure
			String result=(String)procedure.getOutputParameterValue("RESULT");
			System.out.println("RESULT is :"+result);
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
	}// main
}// class
