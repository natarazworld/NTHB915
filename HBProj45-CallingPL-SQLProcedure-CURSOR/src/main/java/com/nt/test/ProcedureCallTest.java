//ProcedureCallTest.java 
package com.nt.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class ProcedureCallTest {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			//create ProcedureCall object
			ProcedureCall call=ses.createStoredProcedureCall(" P_GET_EMPS_BY_SALARY_RANGE ",Employee.class);
			//register  both  IN,OUT params
			call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(100000);  //startRange
			call.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(700000);  //endRange
			call.registerParameter(3, Employee.class,ParameterMode.REF_CURSOR);
			//execute the PL/SQL procedure
			ResultSetOutput output=(ResultSetOutput)call.getOutputs().getCurrent();
			List<Employee> list=output.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
	}// main
}// class
