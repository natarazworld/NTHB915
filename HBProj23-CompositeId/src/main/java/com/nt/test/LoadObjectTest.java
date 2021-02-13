package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.id.PrgmrProjId;
import com.nt.entity.Programmer_Project;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		try(SessionFactory factory=HibernateUtil.getSessionFactory()){
			try(Session ses=factory.openSession()){
				//prepare Id class obj
				  PrgmrProjId id=new PrgmrProjId();
				  id.setPrgmrId(101); id.setProjId(1002);
				  //Load /Get obj
				 Programmer_Project entity=ses.get(Programmer_Project.class, id);
				 if(entity==null)
					  System.out.println("record not found");
				 else
					 System.out.println("record found ::"+entity);
			}//try
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
