package com.nt.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Traveller;
import com.nt.utility.HibernateUtil;

public class TravellerDAOImpl implements ITravellerDAO {

	@Override
	public void saveData() {
		Transaction tx=null;
        try(Session ses=HibernateUtil.getSession()){
        	//prepare objects
        	 Traveller traveller1=new Traveller();
        	 traveller1.setTravellerName("ramesh");
        	 traveller1.setDob(LocalDateTime.now());
        	 traveller1.setNickNames(List.of("chinna","munna","janu"));
        	 traveller1.setPhones(Set.of(554353534L,5353453535L,534535355L));
        	 traveller1.setPlacesVisited(Map.of("indiaTour","jaipur,delhi,goa","nepalTour","Khatmandu,pokra,janakpur"));
        	 
        	 Traveller traveller2=new Traveller();
        	 traveller2.setTravellerName("suresh");
        	 traveller2.setDob(LocalDateTime.now());
        	 traveller2.setNickNames(List.of("bujji","nani","kanna"));
        	 traveller2.setPhones(Set.of(514353534L,5153453535L,512535355L));
        	 traveller2.setPlacesVisited(Map.of("UKTour","london,manchester","USATour","Newyork,NewJersy,Florida"));
        	 tx=ses.beginTransaction();
        	   ses.save(traveller1);
        	   ses.save(traveller2);
        	 tx.commit();
        	 System.out.println("Objects are saved");
        }//try
        catch(HibernateException he) {
        	he.printStackTrace();
        	if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
        		 tx.rollback();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}//method
	
	
	
	
}//class
