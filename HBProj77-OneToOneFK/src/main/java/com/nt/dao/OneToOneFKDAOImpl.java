package com.nt.dao;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.DrivingLicense;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements OneToOneFkDAO {

	@Override
	public void saveDataUsingChild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			    //prepare objs
			 Person p1=new Person("raja", "hyd",LocalDateTime.of(1990,10, 21, 5,50));
			 Person p2=new Person("rajesh", "hyd",LocalDateTime.of(1991,11, 12, 5,50));
			 DrivingLicense license=new DrivingLicense("2-wheeler", "RTA",LocalDateTime.now(), LocalDateTime.of(2041,4,21,9,22));
			 license.setLicenseHolder(p1);
			  tx=ses.beginTransaction();
			     ses.save(license); ses.save(p2);
			  tx.commit();
			  System.out.println("Objects are saved");
		}
		catch(HibernateException he) {
			 he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly() ) {
				tx.rollback();
			System.out.println("objects are not saved");
			}
		}

	}

}
