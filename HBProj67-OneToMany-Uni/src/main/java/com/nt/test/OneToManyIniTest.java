package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToManyIniTest {

	public static void main(String[] args) {
		//get DAO
		OneToManyDAO dao=new OneToManyDAOImpl();
		//dao.saveData();
		//dao.loadDataUsingParent();
		//dao.deleteDataUsingParent();
		//dao.deleteOnlyChildsOfAParent();
		//dao.deleteOneChildFromCollectionChildsBelongingToAParent();
		//dao.addNewChildForExistingParent();
		dao.TransferChildFromOneParentToAnotherParent();
		
      //close SessionFactory
		HibernateUtil.closeSessionFactory();
	}

}
