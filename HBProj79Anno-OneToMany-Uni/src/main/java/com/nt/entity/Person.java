package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="OTOM_ANNO_PERSON")
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private Integer pid;
	
     @NonNull
     @Column(length = 15)
     private  String pname;
     @NonNull
     @Column(length = 15)
     private  String paddrs;
     @NonNull
    
     @OneToMany(targetEntity = BankAccount.class,
                                cascade =CascadeType.ALL,
                                fetch = FetchType.EAGER,
                                orphanRemoval = true)
     @JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
     @LazyCollection(LazyCollectionOption.EXTRA)
     @Fetch(FetchMode.SUBSELECT)
     private Set<BankAccount>  accounts;
     
     public Person() {
		System.out.println("Person:: 0-param constructor");
	}
     
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
     
}
