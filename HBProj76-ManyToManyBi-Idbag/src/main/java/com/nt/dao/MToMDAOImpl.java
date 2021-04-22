package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtil;

public class MToMDAOImpl implements MToMDAO {

	@Override
	public void saveDataUsingChild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()) {
			  //prepare objects
			Doctor doc1=new Doctor("manish", "MD","NIMS");
			Doctor doc2=new Doctor("chari", "MBBS","KIMS");
			Patient pat1=new Patient("babu","hyd", "covid");
			Patient pat2=new Patient("ali","vizag", "fever");
			Patient pat3=new Patient("muttu","delhi", "fever");
			Patient pat4=new Patient("kalyan","newyork", "heart");
			//map childs to parents
			doc1.setPatients(Set.of(pat1,pat2,pat4));
			doc2.setPatients(Set.of(pat1,pat3));
			//map  parents to childs
			pat1.setDoctors(List.of(doc1,doc2));
			pat2.setDoctors(List.of(doc1));
			pat3.setDoctors(List.of(doc2));
			pat4.setDoctors(List.of(doc1));
			//save objs
			tx=ses.beginTransaction();
			     ses.save(pat1); ses.save(pat2); ses.save(pat3);ses.save(pat4);
			   tx.commit();
			   System.out.println("Objects are saved( child to parent)");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		}//catch

		
	}//method

}//class
