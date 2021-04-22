package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {
	 private Integer patId;
	    @NonNull
	    private String patName;
	    @NonNull
	    private String patAddrs;
	    @NonNull
	    private  String problem;
	    private List<Doctor> doctors;
	    
		@Override
		public String toString() {
			return "Patient [patId=" + patId + ", patName=" + patName + ", patAddrs=" + patAddrs + ", problem="
					+ problem + "]";
		}
}//class
