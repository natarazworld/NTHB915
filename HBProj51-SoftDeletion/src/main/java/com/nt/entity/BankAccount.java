package com.nt.entity;

import org.hibernate.annotations.FilterDef;

import lombok.Data;

@Data
public class BankAccount {
	private Long acno;
	private String holderName;
	private Float balance;
	private String status;

}
