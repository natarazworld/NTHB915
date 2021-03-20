//FunctionCallTest.java 
package com.nt.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.procedure.ProcedureCall;

import com.nt.utility.HibernateUtil;

public class FunctionCallTest {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			String result=ses.doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection con) throws SQLException {
					//write plain jdbc code to work with PL/SQL function
					CallableStatement cs=con.prepareCall("{?=call  FX_AUTH(?,?)}");
					cs.registerOutParameter(1,Types.VARCHAR);
					cs.setString(2,"raja");
					cs.setString(3,"rani1");
					cs.execute();
					String result=cs.getString(1);
					return result;
				}//execute(-)
			}//anonymous inner class
			); //method call
			
			System.out.println("Result is::"+result);
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
		
		
	}// main
}// class
