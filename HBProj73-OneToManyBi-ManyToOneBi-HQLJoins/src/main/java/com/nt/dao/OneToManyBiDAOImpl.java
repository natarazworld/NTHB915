package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Owner;
import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	
	
	@Override
	public void loadDataUsingParentToChildJoins() {
	    
		try(Session ses=HibernateUtil.getSession()){
	         //prepare and execute HQL/JPQ Query
			//Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName  from Owner o  inner join  o.vehicles v");
			//Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName  from Owner o  left join  o.vehicles v");
			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName  from Owner o  right outer join  o.vehicles v");
			//Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName  from Owner o  full join  o.vehicles v");
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});
	    }
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//loadDataUsingParent

	@Override
	public void loadDataUsingChildToParentJoins() {
		try(Session ses=HibernateUtil.getSession()){
	         //prepare and execute HQL/JPQ Query
			//Query query=ses.createQuery("select v.vehicleId,v.vehicleName,v.companyName,o.ownerId,o.ownerName,o.ownerAddrs  from Vehicle v  inner join  v.owner o ");
			//Query query=ses.createQuery("select v.vehicleId,v.vehicleName,v.companyName,o.ownerId,o.ownerName,o.ownerAddrs  from Vehicle v  left join  v.owner o ");
			Query query=ses.createQuery("select v.vehicleId,v.vehicleName,v.companyName,o.ownerId,o.ownerName,o.ownerAddrs  from Vehicle v  full join  v.owner o ");
			
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});
	    }
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}

}//class
