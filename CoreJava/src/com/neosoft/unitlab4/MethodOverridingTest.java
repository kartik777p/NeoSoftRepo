package com.neosoft.unitlab4;


class Aclass{
	void m1() {
		System.out.println("class A m1()");
	}
	
	void m2() {
		System.out.println("class A m2()");
	}
}

class Bclass extends Aclass{
	void m1() {
		System.out.println("class B m1()");
	}
	
	void m2() {
		System.out.println("class B m2()");
	}
}



public class MethodOverridingTest {

	public static void main(String[] args) {
		//create subclass obj
		Aclass obj=new Bclass();
		//call overriden method havving parent class ref varible
		obj.m1();
		
	}

}
