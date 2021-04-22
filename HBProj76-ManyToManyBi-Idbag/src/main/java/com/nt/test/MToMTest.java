package com.nt.test;

import com.nt.dao.MToMDAO;
import com.nt.dao.MToMDAOImpl;
import com.nt.utility.HibernateUtil;

public class MToMTest {

	public static void main(String[] args) {
		//create DAO
		MToMDAO  dao=new MToMDAOImpl();
		//invoke methods
		 dao.saveDataUsingChild();
		
		//close Session factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
