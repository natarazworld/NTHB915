package com.nt.entity;

import java.io.Serializable;

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
   private  Integer changeCount;  //for Versoning
}
