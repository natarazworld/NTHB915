package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class InhMappingDAOImpl implements InhMappingDAO {

	@Override
	public void saveData() {
		//get Session object
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			  tx=ses.beginTransaction();
			   //prepare objects
			    Person per=new Person("raja","hyd","HCL");
			    
			    Employee emp=new Employee("CLERK",90000.0f, 1001);
			    emp.setPname("rajesh"); emp.setPaddrs("HYD"); emp.setCompany("WIPRO");
			    
			    Customer cust=new Customer(67888.5f,565.88f);
			    cust.setPname("suresh"); cust.setCompany("zoom"); cust.setPaddrs("delhi");
			    //save object
			     ses.save(cust);
			    ses.save(per);
			    ses.save(emp);
			    System.out.println("Objects aresaved ");
			  tx.commit();
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null  && tx.getRollbackOnly()) { 
			      tx.rollback();
			      System.out.println("Problem in saving object");
			}//if
			}//catch
		}//method
	
	@Override
	public void loadData() {
		try(Session ses=HibernateUtil.getSession()){
			   //prepare and  execute HQL query
			Query query1=ses.createQuery("from Person");
			List<Person> list1=query1.getResultList();
			list1.forEach(per->{
				System.out.println(per);
			});
			System.out.println(".....................................");
			Query query2=ses.createQuery("from Employee");
			List<Employee> list2=query2.getResultList();
			list2.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println(".....................................");
			Query query3=ses.createQuery("from Customer");
			List<Customer> list3=query3.getResultList();
			list3.forEach(cust->{
				System.out.println(cust);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//method
	
	}//class
