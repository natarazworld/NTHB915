//InsurancePolicy.java
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="INSURANCE_POLICY")
/*@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsurancePolicy implements Serializable {
	@Id
	@Column(name="policy_id")
	@GeneratedValue
	private Long  policyId;
	@Column(name="policy_name",length = 20,unique = true,nullable = false)
	private String policyName;
	@Column(name="company",length = 20)
	private  String company;
	@Column(name="tenure")
	private  Float tenure;
	

}
