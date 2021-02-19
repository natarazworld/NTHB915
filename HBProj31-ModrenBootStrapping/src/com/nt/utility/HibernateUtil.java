//HibernateUtil.java
package com.nt.utility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static SessionFactory  factory; 
	 static {
		 
		 try {
			 //Boot strapping the hibernate
			 Configuration cfg=new Configuration();
			 //create ServiceRegistryBuilder
			 StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			 //create SErviceRegsitry
			 StandardServiceRegistry  registry=builder.configure("/com/nt/cfgs/hibernate.cfg.xml").build();
			 //create SessionFactory object
			 factory=cfg.buildSessionFactory(registry);
		
		 }
		 catch(HibernateException he) {
			 he.printStackTrace();
		 }
	 }//static
	 
	 // To create Session obj
	 public static  Session getSession() {
		 Session ses=null;
		 if(factory!=null)
			  ses=factory.openSession();
		 return ses;
	 }
	 
	 //To close Session obj
	 public static   void  closeSession(Session ses) {
		  if(ses!=null)
			  ses.close();
	 }
	 
	 //To close  SessionFactory object
	 public static  void closeSessionFactory() {
		 if(factory!=null)
			 factory.close();
	 }
	 
	 
	 
}//class
