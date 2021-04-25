package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MTOM_ANNO_PATIENT")
public class Patient implements Serializable {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PATID_SEQ",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	 private Integer patId;
	    @NonNull
	    @Column(length = 15)
	    private String patName;
	    
	    @NonNull
	    @Column(length = 15)
	    private String patAddrs;
	    
	    @NonNull
	    @Column(length = 15)
	    private  String problem;
	    @ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="patients")
	    private Set<Doctor> doctors;
	    
		@Override
		public String toString() {
			return "Patient [patId=" + patId + ", patName=" + patName + ", patAddrs=" + patAddrs + ", problem="
					+ problem + "]";
		}
}//class
