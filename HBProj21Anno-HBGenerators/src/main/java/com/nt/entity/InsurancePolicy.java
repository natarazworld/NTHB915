//InsurancePolicy.java
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="INSURANCE_POLICY_GENERATORS")
public class InsurancePolicy implements Serializable {
	/*@Id
	@GenericGenerator(name = "gen1",strategy = "increment")  // To specify details HB Specific generator
	@GeneratedValue(generator = "gen1") // To apply generators on @Id field
	*/
	/*@Id
	@GenericGenerator(name="gen1",strategy = "sequence",
	                                     parameters = {@Parameter(name="sequence_name",value = "POLICYID_SEQ") })
	@	GeneratedValue(generator = "gen1")*/
	@Id
	@GenericGenerator(name="gen1",strategy = "sequence")
	@GeneratedValue(generator = "gen1")
	private Long  policyId;
	
	private String policyName;
	private  String company;
	private  Float tenure;
	

}
