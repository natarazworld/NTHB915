//LoadObjectTest1.java
package com.nt.test;

import java.util.Arrays;

import org.hibernate.Session;

import com.nt.entity.IActor;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest2 {

	public static void main(String[] args) {
		//Get HB Session obj
		Session ses=HibernateUtil.getSession();
		try {
			IActor actor=ses.load(IActor.class,1);
			System.out.println(actor.getClass()+"     "+actor.getClass().getSuperclass()+"  "+Arrays.toString(actor.getClass().getInterfaces()));
		      // System.out.println(actor);
				}
		catch(Exception e) {
			System.out.println("Object not found");
			e.printStackTrace();
		}
		finally {
			//close Session obj (connection closing)
			HibernateUtil.closeSession(ses);
			//close SessionFactory object
			HibernateUtil.closeSessionFactory();
		}//finally   
	
		
		
	}//main
}//class
