package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFitlersTest1_JPAQBC {

	public static void main(String[] args) {
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			// get Access to filter by enabling filter
			Filter filter1=ses.enableFilter("IGNORE_ACCOUNTS_FILTER");
			//set values to filter parameters
			filter1.setParameter("accountType1", "BLOCKED");
			filter1.setParameter("accountType2", "CLOSED");
			filter1.setParameter("accountType3", "SUSPENDED");
			//prepare and  execute JPAQBC  Select qurey
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaQuery<BankAccount> ctQuery=builder.createQuery(BankAccount.class);
			Root<BankAccount> root=ctQuery.from(BankAccount.class);
			Query query =ses.createQuery(ctQuery);
			List<BankAccount> list=query.getResultList();
			list.forEach(System.out::println);
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//main
}//class
