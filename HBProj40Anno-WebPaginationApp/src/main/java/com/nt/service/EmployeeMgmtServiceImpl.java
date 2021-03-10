package com.nt.service;

import java.util.List;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.entity.Employee;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	private IEmployeeDAO dao;
	public EmployeeMgmtServiceImpl() {
		 dao=new EmployeeDAOImpl();
	}
	
	@Override
	public long getPagesCount(int pageSize) {
	   //use DAO to get reords count
		long totalRecords=dao.getRecordsCount();
		long pagesCount=totalRecords/pageSize;
		 if(totalRecords%pageSize!=0)
			 pagesCount++;
		return pagesCount;
	}
	

	@Override
	public List<Employee> fetchEmployeesByPagination(int pageNo, int pageSize) {
		// get StartPosition
		int startPos= (pageNo*pageSize)-pageSize;
		//use DAO
		List<Employee> list=dao.getAllEmployeesByPagination(startPos, pageSize);
		return list;
	}

}
