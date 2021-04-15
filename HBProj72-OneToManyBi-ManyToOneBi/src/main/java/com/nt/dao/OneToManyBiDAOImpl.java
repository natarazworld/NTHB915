package com.nt.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Owner;
import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	@Override
	public void saveDataUsingParent() {
	    Transaction tx=null;
	    try(Session ses=HibernateUtil.getSession()){
	    	//prepare objects  (parent to child save)
	    	Owner  o1=new Owner("raja","hyd");
	    	Vehicle  v1=new Vehicle("baleno","Maruthi-Suzuki");
	    	Vehicle  v2=new Vehicle("innova","Toyota");
	    	//set parent to childs
	    	v1.setOwner(o1); v2.setOwner(o1);
           //set childs to parent
	    	Set <Vehicle> childs=new HashSet();
	    	childs.add(v1); childs.add(v2);
	    	o1.setVehicles(childs);
	    	///begin Tx
	    	tx=ses.beginTransaction();
	    	  ses.save(o1);
	    	 tx.commit();
	    	 System.out.println("Parent and child objects are saved (parent to child)");
	    }//try
	    catch(HibernateException he) {
	    	he.printStackTrace();
	    	if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
	    		tx.rollback();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }

	}

	@Override
	public void saveDataUsingChilds() {
		 Transaction tx=null;
		    try(Session ses=HibernateUtil.getSession()){
		    	//prepare objects  (child to parent)
		    	Owner  o1=new Owner("ravi","delhi");
		    	Vehicle  v1=new Vehicle("ertiga","Maruthi-Suzuki");
		    	Vehicle  v2=new Vehicle("fortuner","Toyota");
		    	//set parent to childs
		    	v1.setOwner(o1); v2.setOwner(o1);
	           //set childs to parent
		    	Set <Vehicle> childs=new HashSet();
		    	childs.add(v1); childs.add(v2);
		    	o1.setVehicles(childs);
		    	///begin Tx
		    	tx=ses.beginTransaction();
		    	   ses.save(v1); ses.save(v2);
		    	 tx.commit();
		    	 System.out.println("Parent and child objects are saved (child to parent)");
		    }//try
		    catch(HibernateException he) {
		    	he.printStackTrace();
		    	if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
		    		tx.rollback();
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    }

		
	}

}
