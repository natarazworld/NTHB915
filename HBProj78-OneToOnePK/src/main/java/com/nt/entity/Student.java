package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Student implements Serializable {
  private Integer sid;
  @NonNull
  private String sname;
  @NonNull
  private String saddrs;
  @NonNull
  private  LocalDateTime dob;
  private LibraryMembership libraryDetails;
  
  public Student() {
	  System.out.println("Student:: 0-param consturctor");
  }

@Override
public String toString() {
	return "Person [sid=" + sid + ", sname=" + sname + ", addrs=" + saddrs + ", dob=" + dob + "]";
}
  
  
  
}
