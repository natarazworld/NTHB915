package com.nt.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class Employee implements Serializable {
	private Integer  eno;
	private String ename;
	private String eadd;
	private Float salary;
	
	public   Employee() {
		System.out.println("Employee::  0-param constructor");
	}

}//class
