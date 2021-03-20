package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="HQL_EMPLOYEE")
@NamedNativeQuery(name = "GET_EMPS_BY_SAL_RANGE",
                                      query = "SELECT ENO,ENAME,EADD,SALARY FROM HQL_EMPLOYEE WHERE SALARY>=? AND SALARY<=?",
                                      resultClass = Employee.class)
@NamedNativeQuery(name = "GET_EMPS_BY_ADDRS",query = "SELECT ENO,EADD,SALARY FROM HQL_EMPLOYEE WHERE EADD=:addrs")


public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer  eno;
	private String ename;
	private String eadd;
	private Float salary;
	
	public   Employee() {
		System.out.println("Employee::  0-param constructor");
	}

}//class
