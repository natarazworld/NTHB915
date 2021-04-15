package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
//child class
public final class Employee implements Serializable,IEmployee {
	private  Integer eno;
	@NonNull
	private String ename;
	@NonNull
	private  String eadd;
	@NonNull
	private  float salary;
	@NonNull
	private  IDepartment dept;   // child to parent association  
	
	public Employee() {
		System.out.println("Employee:: 0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eadd=" + eadd + ", salary=" + salary + "]";
	}
	
	
	

}
