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
public class Person implements Serializable {
  private Integer pid;
  @NonNull
  private String pname;
  @NonNull
  private String paddrs;
  @NonNull
  private  LocalDateTime dob;
  
  public Person() {
	  System.out.println("Person:: 0-param consturctor");
  }

@Override
public String toString() {
	return "Person [pid=" + pid + ", pname=" + pname + ", addrs=" + paddrs + ", dob=" + dob + "]";
}
  
  
  
}
