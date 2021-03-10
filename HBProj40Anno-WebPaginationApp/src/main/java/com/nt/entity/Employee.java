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
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer  eno;
	private String ename;
	private String eadd;
	private Float salary;

}//class
