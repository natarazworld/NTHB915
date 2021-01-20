package com.nt.test;

public class NewInstanceTest {

	public static void main(String[] args) {
	 try {
		 //Load the class
		 Class c=Class.forName(args[0]);
		 //create the object for loaded class dynamically at rutime
		 Object obj=c.newInstance();
		 System.out.println("obj class name::"+obj.getClass()+"  obj hashCode::"+obj.hashCode()+" obj data::"+obj);
		 
	 }//try
	 catch(Exception e) {
		 e.printStackTrace();
	 }

	}//main
}//c;ass
