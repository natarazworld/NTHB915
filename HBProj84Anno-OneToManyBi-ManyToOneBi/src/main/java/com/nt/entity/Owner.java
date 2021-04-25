package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="OTOM_ANNO_BI_OWNER")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ownerId;
	@NonNull
	@Column(length=15)
	private String  ownerName;
	@NonNull
	@Column(length=15)
	private String ownerAddrs;
	//@NonNull
	@OneToMany(targetEntity=Vehicle.class, cascade = CascadeType.ALL,
			                  fetch = FetchType.LAZY,orphanRemoval = true ,mappedBy = "owner")
	private Set<Vehicle> vehicles;   //for One To Many Association
	
	public Owner() {
		System.out.println("Owner:: 0-param constructor");
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerAddrs=" + ownerAddrs + "]";
	}
	
	

}
