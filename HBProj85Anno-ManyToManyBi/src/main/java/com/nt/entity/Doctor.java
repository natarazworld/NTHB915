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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="MTOM_ANNO_DOCTOR")
public class Doctor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  docId;
    @NonNull
    @Column(length=15)
    private String docName;
    @NonNull
    @Column(length=15)
    private String docQlfy;
    @NonNull
    @Column(length=15)
    private  String hospital;
    
    @ManyToMany(targetEntity = Patient.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "MTOM_ANNO_DOCTORS_PATIENTS",
                        joinColumns = @JoinColumn(name="DOCTOR_ID",referencedColumnName = "DOCID"),
                        inverseJoinColumns = @JoinColumn(name="PATIENT_ID",referencedColumnName = "PATID"))
    private Set<Patient> patients;
    
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", docQlfy=" + docQlfy + ", hospital=" + hospital
				+ "]";
	}
    
    
    
}
