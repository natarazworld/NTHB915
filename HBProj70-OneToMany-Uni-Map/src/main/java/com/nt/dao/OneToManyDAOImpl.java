package com.nt.dao;

import java.util.List;
import java.util.Map;

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
			Map<String,BankAccount> accounts=Map.of("salary account",new BankAccount("savings","SBI",616565.0),
					                                                                       "society account", new BankAccount("current","SBH",626665.0));
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

/*	@Override
	public void loadDataUsingParent() {
		try(Session ses=HibernateUtil.getSession()){
			//execute the HQL query
			Query query=ses.createQuery("from Person");
			List<Person> list=query.getResultList();
						list.forEach(per->{
							System.out.println("parent ::"+per);
							//get childs of each parent
								Map<String,BankAccount> childs=per.getAccounts();
								System.out.println("childs count::"+childs.size());
								childs.forEach((type,ba)->{
									System.out.println(type+"---->"+"child::"+ba);
								}); 
						});
					}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}//method

	/*@Override
	public void deleteDataUsingParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//Load parent object
			Person per=ses.get(Person.class, 1);
			//begin the Tx
			tx=ses.beginTransaction();
			//delete obj
				ses.delete(per);
			 tx.commit();
			 System.out.println("Parent and Associated childs are deleted");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) { 
				tx.rollback();
				System.out.println("Parent and Associated childs  not are deleted");
			}
		}
		
	}//method
	
	@Override
	public void deleteOnlyChildsOfAParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//Load parent object
			Person per=ses.get(Person.class, 2);
			//get childs of a parent
			Set<BankAccount> childs=per.getAccounts();
			//begin the Tx
			tx=ses.beginTransaction();
			//delete childs objects
				childs.clear();
			 tx.commit();
			 System.out.println("All childs of a parent are deleted");
     	}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) { 
				tx.rollback();
				System.out.println("All childs of a parent are deleted");
			}
		}
		}//method  

		@Override
		public void deleteOneChildFromCollectionChildsBelongingToAParent() {
			Transaction tx=null;
			try(Session ses=HibernateUtil.getSession()){
				//Load parent object
				Person per=ses.get(Person.class, 1);
				//get all childs of a parent
				Map<String,BankAccount> childs=per.getAccounts();
				//begin the Tx
				tx=ses.beginTransaction();
				//delete one child
	             childs.remove("salary account");
				 tx.commit();
				 System.out.println("Parent and Associated childs are deleted");
			}
			catch(HibernateException he) {
				he.printStackTrace();
				if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) { 
					tx.rollback();
					System.out.println("Parent and Associated childs  not are deleted");
				}
				}
		}//method
		
	/*@Override
	public void addNewChildForExistingParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//Load parent object
			Person per=ses.get(Person.class, 4);
			//get all childs of a parent
			Set<BankAccount> childs=per.getAccounts();
			//create new child object
			BankAccount account=new BankAccount("current", "PNB",50000.0);
			//begin Tx
			tx=ses.beginTransaction();
			      childs.add(account);
			    tx.commit();
			    System.out.println("New child is added to existing parent ");
			
		}
			catch(HibernateException he) {
				he.printStackTrace();
				if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) { 
					tx.rollback();
					System.out.println("Problem in adding New child to existing parent");
				}
				}
			}//method
	
	@Override
	public void TransferChildFromOneParentToAnotherParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//Load parent1 object
			Person per1=ses.get(Person.class, 4);
			//get all childs of a parent1
			Set<BankAccount> childs1=per1.getAccounts();
			//Load parent2 object
			Person per2=ses.get(Person.class, 5);
			//get all childs of a parent2
			Set<BankAccount> childs2=per2.getAccounts();
			//Load that child from Db s/w which want to transfer
			BankAccount account=ses.get(BankAccount.class, 100005L);
			//begin tx
				 tx=ses.beginTransaction();
				          childs1.add(account);
				 tx.commit();
				 Transaction tx1=ses.beginTransaction();
				     childs2.remove(account);
				 tx1.commit();
				 System.out.println("Child record is transfered ");
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
				if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) { 
					tx.rollback();
					System.out.println("Problem in  Child record is transfering");
				}
				}
			}//method  */
	
}//class
