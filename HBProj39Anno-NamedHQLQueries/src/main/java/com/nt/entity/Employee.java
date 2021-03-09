package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="HQL_EMPLOYEE")
/*@NamedQuery(name = "HQL_GET_EMP_DETAILS",query = "FROM Employee WHERE salary>=:start and salary<=:end")
@NamedQuery(name = "HQL_SALARY_BONUS",query = "UPDATE Employee SET salary=salary+:bonus WHERE eadd=:addrs") */

@NamedQueries(value= { @NamedQuery(name = "HQL_GET_EMP_DETAILS",query = "FROM Employee WHERE salary>=:start and salary<=:end"),
                                               @NamedQuery(name = "HQL_SALARY_BONUS",query = "UPDATE Employee SET salary=salary+:bonus WHERE eadd=:addrs")
                                            })
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
