package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeDAO {
	public  List<Employee>  getAllEmployeesByPagination(int startPos,int pageSize);
	public  long  getRecordsCount();

}
