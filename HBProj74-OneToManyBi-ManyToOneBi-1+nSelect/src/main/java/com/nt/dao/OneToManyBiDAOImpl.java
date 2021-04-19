package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

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
			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName  from Owner o  inner join  o.vehicles v");
			//Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName  from Owner o  left join  o.vehicles v");
			//Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName  from Owner o  right outer join  o.vehicles v");
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

	@Override
	public void loadDataUsingParent() {
		try(Session ses=HibernateUtil.getSession()){
			//prepare and execute HQL/JPQL Query
			Query query=ses.createQuery("from Owner");
			List<Owner> list=query.getResultList();
			list.forEach(owner->{
				System.out.println("parent::"+owner);
				Set<Vehicle> childs=owner.getVehicles();
				childs.forEach(vehicle->{
					System.out.println("Child::"+vehicle);
				});
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}
	
	@Override
	public void loadDataUsingParentUsingFetch() {
		try(Session ses=HibernateUtil.getSession()){
			//prepare and execute HQL/JPQL Query
			Query query=ses.createQuery("select o from Owner o inner join fetch o.vehicles v ");
			List<Owner> list=query.getResultList();
			list.forEach(owner->{
				System.out.println("parent::"+owner);
				Set<Vehicle> childs=owner.getVehicles();
				childs.forEach(vehicle->{
					System.out.println("Child::"+vehicle);
				});
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}
	
	@Override
	public void loadDataUsingParentAndQBC() {
		
		 try(	Session ses=HibernateUtil.getSession()){
				//Create CriteriaBuilder object
				CriteriaBuilder  ctBuilder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				CriteriaQuery<Owner> ctQuery=ctBuilder.createQuery(Owner.class);
				//Prepare Object to specify  the from  "DB table/ Entity class name"  // from Employee/HQL_Employee
				Root<Owner > root=ctQuery.from(Owner.class);
				root.fetch("vehicles");
				root.fetch("vehicles", JoinType.LEFT);
				// Sepecify Root object for select operation  
				ctQuery.select(root);
				//prepare Query object to execute the Query
				Query query=ses.createQuery(ctQuery);
				//execute the query
				List<Owner> list=query.getResultList();
				list.forEach(owner->{
					System.out.println("parent::"+owner);
					Set<Vehicle> childs=owner.getVehicles();
					childs.forEach(v->{
						System.out.println("child::"+v);
					});
				});
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			} 
		
	}
	
	@Override
	public void loadDataForDirtyCheck() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//Load Object
			Owner owner=ses.get(Owner.class, 1);
			if(owner!=null)
				System.out.println(owner);
			else
				System.out.println("record not found");
			System.out.println("Session is dirty?"+ses.isDirty());  //false
			//modify the data
			tx=ses.beginTransaction();
			  owner.setOwnerAddrs("vizag");
			  System.out.println("Session is dirty?"+ses.isDirty());  //true
			 tx.commit();
			 System.out.println("Session is dirty?"+ses.isDirty());  //false
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
		}
		
	}

}//class
