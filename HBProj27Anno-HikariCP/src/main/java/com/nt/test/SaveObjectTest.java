package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.id.PrgmrProjId;
import com.nt.entity.Programmer_Project;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		Transaction tx=null;
		try(SessionFactory factory=HibernateUtil.getSessionFactory()){
			try(Session ses=factory.openSession()){
				//begin Tx
				tx=ses.beginTransaction();
				//prepare object
				  PrgmrProjId id=new PrgmrProjId();
				  id.setPrgmrId(102); id.setProjId(1002);
				  Programmer_Project entity=new Programmer_Project();
				  entity.setId(id);  entity.setPrgmrName("raja"); entity.setTeamSize(10);
				  entity.setPrgmrAge(30); entity.setProjName("openFx");
				  //save obj
				 PrgmrProjId idVal=(PrgmrProjId) ses.save(entity);
				  System.out.println("Generated id value::"+idVal.toString());
				  tx.commit();
			}//try
		}//try
		catch(HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				  tx.rollback();
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
