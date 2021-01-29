package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CALLERTUNE_ANNO_TS_VER")
public class CallerTune implements Serializable {
	@Id
	@GeneratedValue  // Generates  id value by using previous val+1  formulae
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
   private  int  changesCount;
   
	/*  @CreationTimestamp
	  @Type(type="timestamp")
	  private Timestamp  createdOn;
	  @UpdateTimestamp
	  @Type(type="timestamp")
	  private Timestamp lastUpdated;*/
   
/*	@CreationTimestamp
	  private LocalDateTime createdOn;
	  @UpdateTimestamp
	  private LocalDateTime lastUpdated; */
   
   	@CreationTimestamp
	  private Date createdOn;
	  @UpdateTimestamp
	  private Date lastUpdated; 


}
