package com.nt.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallerTune implements Serializable {
   private  Integer callerTuneId;
   private  String callerTune;
   private  String  provider;
   private  Long mobileNo;
   //private  Date   lastUpdated;
   @UpdateTimestamp
   private Timestamp lastUpdated;

}
