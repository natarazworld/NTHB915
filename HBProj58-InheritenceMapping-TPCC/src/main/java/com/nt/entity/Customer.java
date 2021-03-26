package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person {
	private  Float billAmt;
	private  Float discount;
	
	@Override
	public String toString() {
		return "Customer [billAmt=" + billAmt + ", discount=" + discount + ", getPid()=" + getPid() + ", getPname()="
				+ getPname() + ", getPaddrs()=" + getPaddrs() + ", getCompany()=" + getCompany() +"])";
	}
	
	

}
