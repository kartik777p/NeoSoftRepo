package com.neosoft.unitlab4;

public class StaticMebersTest {
	
	static int a=30;
	static int b=50;
	
	
	static void m1() {
		System.out.println("This is Static Method");
	}
	
	//Static Block
	static {
		System.out.println("This is Static Block");
	}

	public static void main(String[] args) {
		//the the time of class loading 1st static block will execute 
		//then m1() will excute 
		m1();
		//how many ways we can acess static veriable
		System.out.println("a="+a+" b="+b);     //directly
		System.out.println("a="+StaticMebersTest.a+"b="+StaticMebersTest.b);  //by class name
		//create obj of this class having refrence
		StaticMebersTest mem=new StaticMebersTest();
		System.out.println("a="+mem.a+" b="+mem.b);   //having obj
		StaticMebersTest mem1=null;
		System.out.println("a="+mem1.a+" b="+mem1.b);    //by null ref 
	}

}
