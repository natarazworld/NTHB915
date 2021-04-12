package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//parent class
public class Department implements Serializable {
       private Integer dno;
       @NonNull
       private String  dname;
       @NonNull
       private  String location;
}
