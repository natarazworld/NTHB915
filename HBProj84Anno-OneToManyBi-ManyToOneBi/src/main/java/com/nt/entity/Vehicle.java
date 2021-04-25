package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="OTOM_ANNO_BI_VEHICLE")
public class Vehicle {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "VID_SEQ",initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Long vehicleId;
	@NonNull
	@Column(length=15)
	private String vehicleName;
	@NonNull
	@Column(length=15)
	private  String companyName;
	//@NonNull
	@ManyToOne(targetEntity = Owner.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JoinColumn(name="OWENER_ID",referencedColumnName = "OWNERID")
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
