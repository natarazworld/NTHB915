package com.nt.test;

import com.nt.dao.IPaymentDAO;
import com.nt.dao.PaymentDAOImpl;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingTest {

	public static void main(String[] args) {
		//get DAO
		IPaymentDAO dao=new PaymentDAOImpl();
		dao.saveData();
		//dao.loadData();
		
		//close session factory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
