package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.nt.service.ApacheDBCP2ConnectionProviderService;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
			//Boot strapping of Hibernate  (Modren)
			Configuration cfg=new Configuration();
			// create SErviceRegistryBuilder 
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			//add service registry through Service Registry builder
			builder.addService(ConnectionProvider.class, new ApacheDBCP2ConnectionProviderService());
			//create ServiceRegistry
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
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
}//class
