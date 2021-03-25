package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {
	private String desg;
	private  Float salary;
	private   Integer deptNo;
	
	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", salary=" + salary + ", deptno=" + deptNo + ", getPid()=" + getPid()
				+ ", getPname()=" + getPname() + ", getPaddrs()=" + getPaddrs() + ", getCompany()=" + getCompany()
				+ "]";
	}//method

}//class
