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

public class NativeSelectTest {

	public static void main(String[] args) {
		// Get SesssionFactory and Session objects
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses = factory.openSession()) {
			/*	//pepare and NativeSQL Entity SQL query
				NativeQuery query=ses.createNativeQuery("SELECT * FROM HQL_EMPLOYEE WHERE SALARY>=? AND SALARY<=?");
				query.addEntity(Employee.class); // mapping results with Entity class.
				query.setParameter(1, 600000.0f);
				query.setParameter(2,1000000.0f);
				List<Employee> list=query.getResultList();
				list.forEach(System.out::println);*/

			// pepare and execute NativeSQL Entity SQL query
			/*			NativeQuery query=ses.createNativeQuery("SELECT * FROM HQL_EMPLOYEE WHERE SALARY>=? AND SALARY<=?");
						//query.addEntity(Employee.class); // mapping results with Entity class.
						query.setParameter(1, 600000.0f);
						query.setParameter(2,1000000.0f);
						List<Object[]> list=query.getResultList();
						list.forEach(row->{
							System.out.println(Arrays.toString(row));
						}); */

			/*	//prepare and execute NativeSQL scalar query
				NativeQuery query=ses.createNativeQuery("SELECT ENO,ENAME FROM HQL_EMPLOYEE WHERE EADD IN(?1,?2,?3)");
				//map col names with hibernate data types
				query.addScalar("ENO",StandardBasicTypes.INTEGER);
				query.addScalar("ENAME", StandardBasicTypes.STRING);
				//set values to query params
				query.setParameter(1, "hyd");
				query.setParameter(2,"vizag");
				query.setParameter(3,"delhi");
				//execute the query
				List<Object[]> list=query.getResultList();
				list.forEach(row->{
					for(Object val:row) {
						System.out.print(val+"   ");
					}
					System.out.println();
				}); */

			/*			//prepare and execute NativeSQL scalar query
					NativeQuery query=ses.createNativeQuery("SELECT ENAME FROM HQL_EMPLOYEE WHERE ENAME LIKE :initChars");
					//map col names with hibernate data types
					query.addScalar("ENAME", StandardBasicTypes.STRING);
					//set values to query params
					query.setParameter("initChars", "r%");
					//execute the query
					List<Object> list=query.getResultList();
					//process the results
						list.forEach(name->{
							System.out.println(name);
						});
					list.forEach(System.out::println);*/
			
			//prepare and execute NativeSQL scalar query
			NativeQuery query=ses.createNativeQuery("SELECT COUNT(*) FROM HQL_EMPLOYEE");
			//map col names with hibernate data types
			query.addScalar("COUNT(*)", StandardBasicTypes.INTEGER);
			//execute the query
			List<Integer> list=query.getResultList();
			//process the results
			int count=list.get(0);
			System.out.println("count of records ::"+count);

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
	}// main
}// class
