package com.neosoft.unitlab4;


class A{
	void m1() {
		System.out.println("A m1()");
	}
	
	void m2() {
		System.out.println("A m2()");
	}
	
	void m3() {
		System.out.println("A m4()");
	}
}

class B extends A{
	
	void m4() {
		System.out.println("B m4()");
	}
	
	void m5() {
		System.out.println("B m5()");
	}
}

public class InheritanceTest {
	
	public static void main(String[] args) {
		//craete subclss obj AND CALL SUBCLASS AND SUPER Class methods
		B obj=new B();
		obj.m4();   //subclass method
		obj.m1();    //parent class method
		
	}

}
