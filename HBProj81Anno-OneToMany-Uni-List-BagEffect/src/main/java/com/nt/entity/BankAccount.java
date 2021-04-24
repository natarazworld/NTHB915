package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="OTOM_ANNO_BANKACCOUNT_LIST_BAG")
public class BankAccount implements Serializable{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "ACNO_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
   private Long accountNo;
   @NonNull
   @Column(length = 15)
   private String accountType;
   @NonNull
   @Column(length = 15)
   private  String bankName;
   @NonNull
   private Double balance;
   
   public BankAccount() {
	   System.out.println("BankAccount:: 0-param constructor");
   }
   
}
