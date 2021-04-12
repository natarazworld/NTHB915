package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//child class
public class Employee implements Serializable {
	private  Integer eno;
	@NonNull
	private String ename;
	@NonNull
	private  String eadd;
	@NonNull
	private  float salary;
	@NonNull
	private  Department dept;   // child to parent association  

}
