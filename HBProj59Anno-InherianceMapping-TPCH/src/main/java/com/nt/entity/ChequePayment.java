package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue(value = "CHEQUE")
@Data
public class ChequePayment extends Payment {
	private Long chequeNo;
	@Column(length = 20)
	private  String chequeType;
	
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", getPid()=" + getPid()
				+ ", getAmount()=" + getAmount() + ", getDate()=" + getPdate() + "]";
	}
	
	

}
