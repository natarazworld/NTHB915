//HibernateUtil.java (for web applicaiton)
package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
			//Boot strapping of Hibernate  (Modren)
			Configuration cfg=new Configuration();
			// create SErviceRegistryBuilder 
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			//add service registry through Service Registry builder
			StandardServiceRegistry registry=builder.configure("/com/nt/cfgs/hibernate.cfg.xml").build();
			//create SEssionFactory with SErviceRegistry
			factory=cfg.buildSessionFactory(registry);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}//static block
	
	public static  SessionFactory getSessionFactory() {
			 return factory;
	}
	
	public  static   Session getSession() {
		Session ses=null;
		if(factory!=null) {
			ses=factory.getCurrentSession();
			 //ses=factory.openSession();
		}
       	  return  ses;
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}//class
