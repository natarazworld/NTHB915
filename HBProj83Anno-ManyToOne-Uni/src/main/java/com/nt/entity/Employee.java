package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="MToO_ANNOTATION_EMPLOYEE")
public  class Employee implements Serializable{
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "ENO_SEQ",allocationSize = 1,initialValue = 1000)
	@GeneratedValue(generator = "gen1" , strategy = GenerationType.SEQUENCE)
	private  Integer eno;
	@NonNull
	  @Column(length=15)
	private String ename;
	@NonNull
	@Column(length=15)
	private  String eadd;
	@NonNull
	@Column(length=15)
	private  float salary;
	
	@NonNull
	@ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL, fetch =FetchType.EAGER)
	@JoinColumn(name="DEPT_NO",referencedColumnName = "DNO")
	@LazyToOne(LazyToOneOption.PROXY)
	private  Department dept;   // child to parent association  
	
	public Employee() {
		System.out.println("Employee:: 0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eadd=" + eadd + ", salary=" + salary + "]";
	}
	
	
	

}
