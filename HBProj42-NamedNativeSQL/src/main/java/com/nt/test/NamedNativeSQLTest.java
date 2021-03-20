package com.nt.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			  //get Access to NamedNativeSQL query
			NativeQuery query=ses.getNamedNativeQuery("GET_EMPS_BY_SAL_RANGE");
			//set param values
			query.setParameter(1, 300000.65f);
			query.setParameter(2,800000.0f);
			//eexecute the query
			List<Employee>  list=query.getResultList();
			//process the results
			list.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println(".......................................");
			  //get Access to NamedNativeSQL query
					NativeQuery query1=ses.getNamedNativeQuery("GET_EMPS_BY_ADDRS");
					//set param values
					query1.setParameter("addrs", "hyd");
					//eexecute the query
					List<Object[]>  list1=query1.getResultList();
					//process the results
					list1.forEach(row->{
						for(Object val:row) {
							System.out.print(val+"  ");
						}
						System.out.println();
					});
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
	}// main
}// class
