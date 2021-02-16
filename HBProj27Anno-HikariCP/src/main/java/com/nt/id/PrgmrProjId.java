package com.nt.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PrgmrProjId implements Serializable {
	private  Integer prgmrId;
	private Integer projId;

}
