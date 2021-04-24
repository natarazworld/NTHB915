package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveData() {
		
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			  //prepare objects
			List<BankAccount> accounts=List.of(new BankAccount("savings","SBI",616565.0),
					                                                       new BankAccount("current","SBH",626665.0));
			 Person per=new Person("rajesh","delhi",accounts); 
				//begin Tx
			 tx=ses.beginTransaction();
			    //save objs
			 ses.save(per);
			 tx.commit();
			 System.out.println("Objects is saved (parent to child)");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null  || tx.getRollbackOnly())
				  tx.rollback();
		}//catch

	}//method

		
}//class
