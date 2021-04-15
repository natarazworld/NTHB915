package com.nt.dao;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.entity.IDepartment;
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
	
	@Override
	public void deletingAllChildsAndItsParent() {
		//get Session
				Transaction tx=null;
				try(Session ses=HibernateUtil.getSession()){
					//Load both childs that want to delete  ( make sure that both are belonging to same parent)
					  Employee emp1=ses.get(Employee.class,1022);
					  Employee emp2=ses.get(Employee.class,1023);
                  //begin Tx
					    tx=ses.beginTransaction();
					        ses.delete(emp1);
                           ses.delete(emp2);					        
					  tx.commit();
					  System.out.println("All childs and  its parent are deleted");
				}
				catch(HibernateException se) {
					se.printStackTrace();
					if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly()) {
						  tx.rollback();
					      System.out.println("Problem in All childs and  its parent are deletion");
					}//if
				}//catch
		
	}//method\
	
	/*@Override
	public void deletingOneChildFromCollectionOfChildsBelonginToAParent() {
		//get Session
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//Load a child that want to delete 
			  Employee emp1=ses.get(Employee.class,1021);
	      //begin Tx
			    tx=ses.beginTransaction();
			        ses.delete(emp1);
			  tx.commit();
			  System.out.println("One child of Collection childs belonging to a Parent  is deleted");
		}
		catch(HibernateException se) {
			se.printStackTrace();
			if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Problem in One child of Collection of childs belonging to a Parent   deletion");
			}//if
		}//catch
	}*/
	
	@Override
	public void deletingOneChildFromCollectionOfChildsBelonginToAParent() {
		//get Session
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
	      //begin Tx
			    tx=ses.beginTransaction();
			       //prepare and execute  HQL query
			     Query query=ses.createQuery("DELETE FROM Employee WHERE eno=?1");
			     query.setParameter(1,1021);
			     int count=query.executeUpdate();
			     if(count==1)
			    	 System.out.println("One child of Collection childs belonging to a Parent  is deleted");
			  tx.commit();
		}
		catch(HibernateException se) {
			se.printStackTrace();
			if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Problem in One child of Collection of childs belonging to a Parent   deletion");
			}//if
		}//catch
	}

	@Override
	public void loadDataUsingChild() {
		//get Session
		try(Session ses=HibernateUtil.getSession()){
			       //prepare and execute  HQL query
								     Query query=ses.createQuery(" FROM Employee");
										     List<Employee> list=query.getResultList();
												/*			  list.forEach(emp->{
															 	 System.out.println("Child ::"+emp); 
																 IDepartment dept=emp.getDept();
															 	 System.out.println("Parent::"+dept);
															  });*/
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//method

}//class
