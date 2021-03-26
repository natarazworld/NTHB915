package com.nt.test;

import com.nt.dao.InhMappingDAO;
import com.nt.dao.InhMappingDAOImpl;
import com.nt.utility.HibernateUtil;

public class InhMappingTest {

	public static void main(String[] args) {
		 InhMappingDAO dao=new InhMappingDAOImpl();
		// dao.saveData();
		 dao.loadData();
		 
		 //close SessionFactory
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
