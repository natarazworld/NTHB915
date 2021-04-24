package com.nt.dao;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class MToODAOImpl  implements MToODAO {

	@Override
	public void saveData() {
		//get Session
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
		    	//prepare objects
			          Department dept1=new Department("ACCOUNTS","hyd");
			          Department dept2=new Department("IT","hyd");
			          Employee emp1=new Employee("raja", "hyd",9000.0f, dept1);
			          Employee emp2=new Employee("rajesh", "vizag",9000.0f, dept1);
			          Employee emp3=new Employee("ramesh", "delhi",19000.0f, dept2);
			          Employee emp4=new Employee("suresh", "hyd",9000.0f, dept2);
                     //begin Tx
			            tx=ses.beginTransaction();
			            ses.save(emp1); ses.save(emp2);
			               ses.save(emp3); ses.save(emp4);
			            tx.commit();
			            System.out.println("Objects are saved (child to parent)");
		  }//try
		catch(HibernateException se) {
			se.printStackTrace();
			if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly()) {
				  tx.rollback();
			      System.out.println("Objects are not saved (child to parent)");
			}//if
		}//catch
		}//saveData()
	
	
}//class
