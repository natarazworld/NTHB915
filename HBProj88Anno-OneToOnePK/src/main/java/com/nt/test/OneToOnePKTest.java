package com.nt.test;

import com.nt.dao.OneToOnePKDAOImpl;
import com.nt.dao.OneToOnePKDAO;
import com.nt.utility.HibernateUtil;

public class OneToOnePKTest {

	public static void main(String[] args) {
		OneToOnePKDAO dao=new OneToOnePKDAOImpl();
		 dao.saveDataUsingParent();
		   //dao.loadDataUsingChild();
		// dao.removeDataUsingChild();
		  
		 //close Sessionfactory
		 HibernateUtil.closeSessionFactory();

	}

}
