package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount implements Serializable{
   private Long accountNo;
   @NonNull
   private String accountType;
   @NonNull
   private  String bankName;
   @NonNull
   private Double balance;
}
