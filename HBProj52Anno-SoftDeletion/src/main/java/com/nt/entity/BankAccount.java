package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE BANKACCOUNT SET STATUS='CLOSED' WHERE ACNO=?")
@Where(clause="STATUS NOT IN('CLOSED','BLOCKED','SUSPENDED')")
public class BankAccount {
	@Id
	private Long acno;
	private String holderName;
	private Float balance;
	private String status;

}
