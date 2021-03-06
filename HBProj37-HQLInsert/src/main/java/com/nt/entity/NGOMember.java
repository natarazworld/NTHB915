package com.nt.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class NGOMember implements Serializable {
	private Integer  mid;
	private String ename;
	private String eadd;
	private Float salary;
	
	public   NGOMember() {
		System.out.println("NGOMember::  0-param constructor");
	}

}//class
