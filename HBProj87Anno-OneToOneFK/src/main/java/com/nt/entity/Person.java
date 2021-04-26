package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="OTOO_ANNO_PERSON")
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer pid;
  @NonNull
  @Column(length=15)
  private String pname;
  @NonNull
  @Column(length=15)
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
