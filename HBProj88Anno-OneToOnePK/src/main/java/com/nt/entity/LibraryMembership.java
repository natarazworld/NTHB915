package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="OTOO_ANNO_PK_LIBRARY")
public class LibraryMembership implements Serializable {
	
	@Id
	@GenericGenerator(name = "gen1",strategy = "foreign",
	                                           parameters = @Parameter(name = "property", value = "studentDetails"))
	@GeneratedValue(generator = "gen1")
    private Integer lid;
    @NonNull
    @Column(length=15)
    private  String membershipType;
    @NonNull
    @Column(length=15)
    private  String issuedBy;
    @NonNull
    private  LocalDateTime validFrom;
    @NonNull
    private  LocalDateTime validTo;
    
    @OneToOne(targetEntity = Student.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval =true)
    @PrimaryKeyJoinColumn(name = "LID",referencedColumnName = "SID")
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
