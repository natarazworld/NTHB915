package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person implements Serializable {
	private Integer pid;
	@NonNull
	private String pname;
	@NonNull
	private String paddrs;
	@NonNull
	private String company;
	

}
