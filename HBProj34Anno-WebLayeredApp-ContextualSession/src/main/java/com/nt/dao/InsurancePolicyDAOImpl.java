package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class InsurancePolicyDAOImpl implements IInsurancePolicyDAO {

	@Override
	public InsurancePolicy getDetailsById(Long policyId) {
	    //get Session 
		try(Session ses=HibernateUtil.getSession()){
			 Session ses1=HibernateUtil.getSession();
			 System.out.println(ses.hashCode()+"  "+ses1.hashCode());
			 Transaction tx=ses.beginTransaction(); //dummy Tx
		//Load object
		InsurancePolicy  policy=ses.get(InsurancePolicy.class, policyId);
		if(policy!=null)
		    return policy;
		else
			return null;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			throw he;
		}
	}//method

}//class
