package com.nt.entity;

import java.io.Serializable;

import com.nt.id.PrgmrProjId;

import lombok.Data;

@Data
public class Programmer_Project implements Serializable {
    private PrgmrProjId  id;  //HAS -A property to suppport composite Id
    private  String prgmrName;
    private  Integer  prgmrAge;
    private  String projName;
    private   Integer teamSize;
}
