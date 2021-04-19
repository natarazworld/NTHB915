package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Doctor implements Serializable {
    private Integer  docId;
    @NonNull
    private String docName;
    @NonNull
    private String docQlfy;
    @NonNull
    private  String hospital;
    private Set<Patient> patients;
    
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", docQlfy=" + docQlfy + ", hospital=" + hospital
				+ "]";
	}
    
    
    
}
