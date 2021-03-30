package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="INH_CHEQUEPAYMENT_TPSC")
@PrimaryKeyJoinColumn(name="PAYMENT_ID",referencedColumnName ="PID")  //To specify FK column
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
