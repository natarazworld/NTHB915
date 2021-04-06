package com.nt.test;

import com.nt.dao.ITravellerDAO;
import com.nt.dao.TravellerDAOImpl;
import com.nt.utility.HibernateUtil;

public class CollectionMappingTest {

	public static void main(String[] args) {
		//get DAO class object
		ITravellerDAO dao=new TravellerDAOImpl();
		dao.saveData();
		
		//close SEssionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
