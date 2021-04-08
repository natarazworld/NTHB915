package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@NoArgsConstructor
@RequiredArgsConstructor
public class Person implements Serializable {
     private Integer pid;
     @NonNull
     private  String pname;
     @NonNull
     private  String paddrs;
     @NonNull
     
     private Set<BankAccount>  accounts;
     
     public Person() {
		System.out.println("Person:: 0-param constructor");
	}
     
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
     
}
