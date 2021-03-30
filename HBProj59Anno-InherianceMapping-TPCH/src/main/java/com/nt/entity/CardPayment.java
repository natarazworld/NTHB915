package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import lombok.Data;

@Entity
@DiscriminatorValue("CARD")
@Data	
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
