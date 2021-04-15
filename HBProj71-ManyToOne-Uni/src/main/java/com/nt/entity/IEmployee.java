package com.nt.entity;

public interface IEmployee {
	 Integer getEno();
	 void setEno(Integer eno);
	 String getEname();
	 void setEname(String ename);
	 String getEadd();
	 void setEadd(String eadd);
	 IDepartment getDept();
	 void setDept(IDepartment dept);
}
