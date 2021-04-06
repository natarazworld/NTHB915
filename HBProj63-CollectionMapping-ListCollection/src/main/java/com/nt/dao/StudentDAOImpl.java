package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void saveData() {
	
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
		   tx=ses.beginTransaction();
		    //prepare objects
		    List<String> friendsList1=List.of("srinivas","sudheer","ramesh","karan");
		    Student  st1=new Student("raja","java",friendsList1);
		    List<String> friendsList2=List.of("ani","madhu","ramana","chinna");
		    Student  st2=new Student("ramesh","spring",friendsList2);
		    ses.save(st1); ses.save(st2);
		   tx.commit();
		   System.out.println("Objects are saved");
		}
		catch(Exception e) {
			e.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			   tx.rollback();
			   System.out.println("Objects are not saved");
			}
		}
		
	}//method
	
	@Override
	public void displayData() {
		try(Session ses=HibernateUtil.getSession()){
			Query query=ses.createQuery("from Student");
			List<Student> list=query.getResultList();
			list.forEach(st->{
				System.out.println("Student details:"+st.getSid()+" "+st.getSname()+" "+st.getCourse());
				System.out.println("friends info");
				List<String> friendsList=st.getFriends();
				friendsList.forEach(System.out::println);
			});
		}
		
	}
	

}
