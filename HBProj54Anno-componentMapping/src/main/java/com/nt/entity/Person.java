//Person.java
package com.nt.entity;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="PERSON_JOB_DETAILS")
public class Person {
	@Id
	@GeneratedValue
  private int pid;
  @NonNull
  private String pname;
  @NonNull
  @Embedded
  private JobDetails details;
}
