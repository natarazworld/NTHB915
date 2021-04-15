package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
//parent class
public class Department implements Serializable,IDepartment{
       private Integer dno;
       @NonNull
       private String  dname;
       @NonNull
       private  String location;
       
       public Department() {
    	   System.out.println("Department:: 0-param constructor::"+this.getClass()+" "+this.getClass().getSuperclass());
       }

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", location=" + location + "]";
	}
       
       
}
