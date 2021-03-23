//JobDetails.java
package com.nt.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class JobDetails {
	private String desg;
	private String  company;
	private  Float salary;

}
