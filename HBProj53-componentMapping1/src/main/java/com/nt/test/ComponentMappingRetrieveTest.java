// ComponentMappingRetrieveTest.java
package com.nt.test;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingRetrieveTest {

	public static void main(String[] args) {
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				 Session ses=factory.openSession()){
			/*Query query=ses.createQuery("from Person");
			List<Person> list=query.getResultList();
			list.forEach(per->{
			  System.out.println(per.getPid()+" "+per.getPname()+
					  " "+per.getDetails().getCompany()+"  "+per.getDetails().getDesg()+" "+per.getDetails().getSalary());
			});*/
			
			Query query=ses.createQuery("from Person  where details.desg=:role");
			query.setParameter("role","CLERK");
			List<Person> list=query.getResultList();
			list.forEach(per->{
			  System.out.println(per.getPid()+" "+per.getPname()+
					  " "+per.getDetails().getCompany()+"  "+per.getDetails().getDesg()+" "+per.getDetails().getSalary());
			});
		  
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			
		}
		

	}//main
}//class

