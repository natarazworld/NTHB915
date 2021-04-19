package com.nt.test;


import com.nt.dao.OneToManyBiDAO;
import com.nt.dao.OneToManyBiDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToManyBiTest {

	public static void main(String[] args) {
		//create DAO class object
            OneToManyBiDAO dao=new  OneToManyBiDAOImpl();		
		   // dao.loadDataUsingParentToChildJoins();
           // dao.loadDataUsingParentUsingFetch();
            //dao.loadDataUsingParentAndQBC();
            dao.loadDataForDirtyCheck();
            //dao.loadDataUsingChildToParentJoins();
		    // dao.loadDataUsingParent();
		//close Sessionfactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
