package com.nt.test;

import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.utility.HibernateUtil;

public class CollectionMappingTest {

	public static void main(String[] args) {
		//create DAO class object
		StudentDAO dao=new StudentDAOImpl();
		dao.saveData();
		// dao.displayData();
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}

}
