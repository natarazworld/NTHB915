package com.nt.comp;
public class Test {
	private int a=10;
	private int b=20;
	
	public Test() {
		System.out.println("Test.Test()");
	}

	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}
	
}
