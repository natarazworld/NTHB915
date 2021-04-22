package com.nt.test;

import com.nt.dao.OneToOneFKDAOImpl;
import com.nt.dao.OneToOneFkDAO;
import com.nt.utility.HibernateUtil;

public class OneToOneFkTest {

	public static void main(String[] args) {
		OneToOneFkDAO dao=new OneToOneFKDAOImpl();
		 dao.saveDataUsingChild();
		  
		 //close Sessionfactory
		 HibernateUtil.closeSessionFactory();

	}

}
