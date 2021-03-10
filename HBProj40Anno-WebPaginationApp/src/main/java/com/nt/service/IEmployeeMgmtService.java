package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public List<Employee>  fetchEmployeesByPagination(int pageNo,int pageSize);
	public  long   getPagesCount(int pageSize);
}
