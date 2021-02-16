package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.nt.id.PrgmrProjId;

import lombok.Data;

@Data
@Entity
public class Programmer_Project implements Serializable {
	@EmbeddedId
    private PrgmrProjId  id;  //HAS -A property to suppport composite Id
	@Column(length=20)
    private  String prgmrName;
    private  Integer  prgmrAge;
    @Column(length=20)
    private  String projName;
    private   Integer teamSize;
}
