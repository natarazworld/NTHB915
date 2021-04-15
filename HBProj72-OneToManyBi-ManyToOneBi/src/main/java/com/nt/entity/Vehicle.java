package com.nt.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Vehicle {
	private Long vehicleId;
	@NonNull
	private String vehicleName;
	@NonNull
	private  String companyName;
	//@NonNull
	private  Owner  owner;  //To build many to One Association
	
	public Vehicle() {
		System.out.println("Vehicle:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", companyName=" + companyName
				+ "]";
	}
	
	
	
	
	

}
