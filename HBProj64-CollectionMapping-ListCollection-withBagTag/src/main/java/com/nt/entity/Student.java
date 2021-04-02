package com.nt.entity;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {
	private  int sid;
	@NonNull
	private  String sname;
	@NonNull
	private  String course;
	@NonNull
	private List<String> friends;  //collection type property.

}
