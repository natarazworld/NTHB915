package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CallerTune implements Serializable {
	@Id
	@GeneratedValue  // default generator  is AUTO (which use previous +1 formulae)
	@Type(type="int")
   private  Integer callerTuneId;
	
	@Column(length=20)
	@Type(type="string")
   private  String callerTune;
	
	@Column(length=20)
	@Type(type="string")
   private  String  provider;
	
	@Type(type="long")
   private  Long mobileNo;
	
   @Version 
   @Type(type="int")
   private  Integer changeCount;  //for Versoning
}
