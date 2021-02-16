//InsurancePolicy.java
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="INSURANCE_POLICY")
public class InsurancePolicy implements Serializable {
	@Id
	private Long  policyId;
	@Column(length=20)
	private String policyName;
	@Column(length=20)
	private  String company;
	private  Float tenure;
	

}
