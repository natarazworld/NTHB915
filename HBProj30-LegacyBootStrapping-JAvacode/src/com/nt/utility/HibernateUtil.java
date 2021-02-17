package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static SessionFactory  factory; 
	 static {
		 
		 try {
			 //Boot strapping the hibernate
			 Configuration cfg=new Configuration();
			 //Programatic..
			 cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
			 cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
			 cfg.setProperty("hibernate.connection.username","system");
			 cfg.setProperty("hibernate.connection.password","manager");
			 cfg.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			 cfg.setProperty("hibernate.hbm2ddl.auto","update");
			 cfg.setProperty("hibernate.show_sql","true");
			 cfg.setProperty("hibernate.format_sql","true");
			 

			 //add mapping file 
			 cfg.addFile("src/com/nt/entity/Actor.hbm.xml"); //for mapping file (xml)
			 //cfg.addAnnotatedClass(Actor.class);
			 //create SessionFactory object
			 factory=cfg.buildSessionFactory();
		
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
