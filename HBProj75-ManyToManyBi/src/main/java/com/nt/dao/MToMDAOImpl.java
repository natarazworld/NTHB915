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
	public void saveDataUsingParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()) {
			  //prepare objects
			Doctor doc1=new Doctor("raja", "MD","NIMS");
			Doctor doc2=new Doctor("suresh", "MBBS","KIMS");
			Patient pat1=new Patient("karan","hyd", "covid");
			Patient pat2=new Patient("jani","vizag", "fever");
			Patient pat3=new Patient("ramesh","delhi", "fever");
			Patient pat4=new Patient("mahesh","newyork", "heart");
			//map childs to parents
			doc1.setPatients(Set.of(pat1,pat2,pat4));
			doc2.setPatients(Set.of(pat1,pat3));
			//map  parents to childs
			pat1.setDoctors(Set.of(doc1,doc2));
			pat2.setDoctors(Set.of(doc1));
			pat3.setDoctors(Set.of(doc2));
			pat4.setDoctors(Set.of(doc1));
			//save objs
			tx=ses.beginTransaction();
			   ses.save(doc1); ses.save(doc2);
			   tx.commit();
			   System.out.println("Objects are saved(parent to child)");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		}//catch

	}//method
	
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
			pat1.setDoctors(Set.of(doc1,doc2));
			pat2.setDoctors(Set.of(doc1));
			pat3.setDoctors(Set.of(doc2));
			pat4.setDoctors(Set.of(doc1));
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

		
	}//methid
	
	@Override
	public void loadDataUsingParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()) {
			 //prepare and execute HQL/JPQL Query
			Query query=ses.createQuery("from Doctor");
			List<Doctor> list=query.getResultList();
			list.forEach(doc->{
				System.out.println("parent::"+doc);
				Set<Patient> childs=doc.getPatients();
				childs.forEach(pat->{
					System.out.println("patient::"+pat);
				});
				System.out.println("--------------------");
			});
			
			
			
		}
		
	}

}//class
