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
@Table(name="INSURANCE_POLICY_GENERATORS")
public class InsurancePolicy implements Serializable {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)*/
	/*	@Id
		@SequenceGenerator(name = "gen1",sequenceName = "PLCYID_SEQ",initialValue = 50,allocationSize = 5)
		@GeneratedValue(generator ="gen1",strategy = GenerationType.SEQUENCE)*/
	
	/*@Id
	@TableGenerator(name = "gen1",table = "IDGEN_TAB",pkColumnName = "PK_COL",pkColumnValue = "POLICYID",valueColumnName = "VAL_COL",initialValue = 1000,allocationSize =5)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)
	*/
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.TABLE)*/
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue
	private Long  policyId;
	@Column(length=20)
	private String policyName;
	@Column(length=20)
	private  String company;
	private  Float tenure;
	

}
