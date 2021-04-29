package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="OTOO_ANNO_PK_STUDENT")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer sid;
  @NonNull
  @Column(length=15)
  private String sname;
  @NonNull
  @Column(length=15)
  private String saddrs;
  @NonNull
  private  LocalDateTime dob;
  @OneToOne(targetEntity = LibraryMembership.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,
		  mappedBy = "studentDetails")
  
  private LibraryMembership libraryDetails;
  
  public Student() {
	  System.out.println("Student:: 0-param consturctor");
  }

@Override
public String toString() {
	return "Person [sid=" + sid + ", sname=" + sname + ", addrs=" + saddrs + ", dob=" + dob + "]";
}
  
  
  
}
