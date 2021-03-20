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
			ProcedureCall call=ses.createStoredProcedureCall("P_GET_EMPS_BY_ADDRSES");
			//register  both  IN,OUT params
			call.registerParameter(1, String.class, ParameterMode.IN).bindValue("hyd");  //startRange
			call.registerParameter(2, String.class, ParameterMode.IN).bindValue("vizag");  //endRange
			call.registerParameter(3, new Object[] {}.getClass(),ParameterMode.REF_CURSOR);
			//execute the PL/SQL procedure
			ResultSetOutput output=(ResultSetOutput)call.getOutputs().getCurrent();
			List<Object[]> list=output.getResultList();
			list.forEach(row->{
				  for(Object val:row) {
					  System.out.print(val+"   ");
				  }
				  System.out.println();
			});
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
	}// main
}// class
