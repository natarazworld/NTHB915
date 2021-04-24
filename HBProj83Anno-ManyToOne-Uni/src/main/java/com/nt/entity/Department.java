package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="MToO_ANNOTATION_DEPARTMENT")
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
       private Integer dno;
       @NonNull
       @Column(length=15)
       private String  dname;
       @NonNull
       @Column(length=15)
       private  String location;
       

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", location=" + location + "]";
	}
       
       
}
