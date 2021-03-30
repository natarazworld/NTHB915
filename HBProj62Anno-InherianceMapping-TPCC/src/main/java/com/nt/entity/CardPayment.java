package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="INH_CARDPAYMENT_TPCC")
public class CardPayment extends Payment {
	private Long cardNo;
	@Column(length = 20)
	private  String cardType;
	@Column(length = 20)
	private String gateway;
	
	
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", gateway=" + gateway + ", getPid()="
				+ getPid() + ", getAmount()=" + getAmount() + ", getpDate()=" + getPdate() + "]";
	}
	
	

}
