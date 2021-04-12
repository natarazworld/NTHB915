package com.nt.test;

import com.nt.dao.MToODAO;
import com.nt.dao.MToODAOImpl;
import com.nt.utility.HibernateUtil;

public class MToOTest {

	public static void main(String[] args) {
		//create DAO class object
		MToODAO  dao=new MToODAOImpl();
		//dao.saveData();
		// dao.deletingAllChildsAndItsParent();
		 //dao.deletingOneChildFromCollectionOfChildsBelonginToAParent();
		dao.deletingOneChildFromCollectionOfChildsBelonginToAParent();
		
		//close Sessionfactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
