package com.nt.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOnePKDAOImpl implements OneToOnePKDAO {

	@Override
	public void saveDataUsingParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			    //prepare objs
			 Student s1=new Student("raja", "hyd",LocalDateTime.of(1990,10, 21, 5,50));
			 Student s2=new Student("rajesh", "hyd",LocalDateTime.of(1991,11, 12, 5,50));
			 LibraryMembership library1=new LibraryMembership("gold", "Miss.Karnua",LocalDateTime.now(), LocalDateTime.of(2041,4,21,9,22));
			 LibraryMembership library2=new LibraryMembership("silver", "Miss.Karnua",LocalDateTime.now(), LocalDateTime.of(2031,1,21,9,22));
			 s1.setLibraryDetails(library1); library1.setStudentDetails(s1);
			 s2.setLibraryDetails(library2);  library2.setStudentDetails(s2);
			  tx=ses.beginTransaction();
			    ses.save(s1); ses.save(s2);
			  tx.commit();
			  System.out.println("Objects are saved");
		}
		catch(HibernateException he) {
			 he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly() ) {
				tx.rollback();
			System.out.println("objects are not saved");
			}
		}

	}

	@Override
	public void loadDataUsingChild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//prepare and execute query
			Query query=ses.createQuery("from LibraryMembership");
			List<LibraryMembership> list=query.getResultList();
			list.forEach(lib->{
			   System.out.println("child ::"+lib);
			   Student st=lib.getStudentDetails();
			  System.out.println("parent ::"+st);
			});
		}//try
		catch(HibernateException he) {
		     he.printStackTrace();
			}
		}//method
	
	@Override
	public void removeDataUsingChild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
               //Load child object
			   LibraryMembership lib=ses.get(LibraryMembership.class,1);
			   tx=ses.beginTransaction();
			         ses.delete(lib);
			   tx.commit();
			   System.out.println("child and its associated parent obj is deleted");
		}
		catch(HibernateException he) {
			 he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly() ) {
				tx.rollback();
			System.out.println("objects are not deleted");
			}
		}
		
	}

}//class
