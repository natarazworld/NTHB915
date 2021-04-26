package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="OTOO_ANNO_LICENSE")
public class DrivingLicense implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName ="LID_SEQ",initialValue = 10000,allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer lid;
    @NonNull
    @Column(length = 10)
    private  String licenseType;
    @NonNull
    @Column(length = 10)
    private  String issuedBy;
    @NonNull
    private  LocalDateTime validFrom;
    @NonNull
    private  LocalDateTime validTo;
    @OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY )
    @JoinColumn(name="PERSON_ID",referencedColumnName = "PID")
    private Person  licenseHolder;  //special property to build one to one FK
    
    public DrivingLicense() {
		System.out.println("DrivingLicense:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", licenseType=" + licenseType + ", issuedBy=" + issuedBy + ", validFrom="
				+ validFrom + ", validTo=" + validTo + "]";
	}
    
    
    
}
