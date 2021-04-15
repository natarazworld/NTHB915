package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Owner {
	private Integer ownerId;
	@NonNull
	private String  ownerName;
	@NonNull
	private String ownerAddrs;
	//@NonNull
	private Set<Vehicle> vehicles;   //for One To Many Association
	
	public Owner() {
		System.out.println("Owner:: 0-param constructor");
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerAddrs=" + ownerAddrs + "]";
	}
	
	

}
