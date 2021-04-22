package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DrivingLicense implements Serializable {
	
    private Integer lid;
    @NonNull
    private  String licenseType;
    @NonNull
    private  String issuedBy;
    @NonNull
    private  LocalDateTime validFrom;
    @NonNull
    private  LocalDateTime validTo;
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
