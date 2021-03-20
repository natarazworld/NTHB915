package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFitlersTest1_NativeSQLjava {

	public static void main(String[] args) {
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			// get Access to filter by enabling filter
			Filter filter1=ses.enableFilter("IGNORE_ACCOUNTS_FILTER");
			//set values to filter parameters
			filter1.setParameter("accountType1", "BLOCKED");
			filter1.setParameter("accountType2", "CLOSED");
			filter1.setParameter("accountType3", "SUSPENDED");
			//prepare and  execute Native SQL Select qury
			NativeQuery query=ses.createNativeQuery("SELECT * FROM BANKACCOUNT");
			query.addEntity(BankAccount.class);
             List<BankAccount> list=query.getResultList();
             list.forEach(acc->{
            	 System.out.println(acc);
             });
             //To disable filer
             ses.disableFilter("IGNORE_ACCOUNTS_FILTER");
             NativeQuery query1=ses.createNativeQuery("SELECT COUNT(*) FROM BANKACCOUNT");
             query1.addScalar("count(*)",StandardBasicTypes.INTEGER);
             List<BankAccount> list1=query1.getResultList();
             System.out.println("Recrods count::"+list1.get(0));
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//main
}//class
