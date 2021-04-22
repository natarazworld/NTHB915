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
public class LibraryMembership implements Serializable {
	
    private Integer lid;
    @NonNull
    private  String membershipType;
    @NonNull
    private  String issuedBy;
    @NonNull
    private  LocalDateTime validFrom;
    @NonNull
    private  LocalDateTime validTo;
    private Student studentDetails;  //special property to build one to one FK
    
    public LibraryMembership() {
		System.out.println("LibraryMembership:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", membershipType=" + membershipType + ", issuedBy=" + issuedBy + ", validFrom="
				+ validFrom + ", validTo=" + validTo + "]";
	}
    
    
    
}
