package com.neosoft.unitlab4;

class Parent{
	int a;
	int b;
	//cons
	public Parent(int a, int b) {
		super();    //obj class
		this.a = a;
		this.b = b;
		
		System.out.println("a="+a+" b="+b);
	}
}

class Chield extends Parent{
	int c,d,e;
//cons
public Chield(int a, int b, int c, int d, int e) {
		super(a, b);
		this.c = c;
		this.d = d;
		this.e = e;
		
		System.out.println("a="+a+" b="+b+" c="+c+" d="+d+" e="+e);
	}
}


public  class SuperKeywordTest{
	public static void main(String[] args) {
		    //call subclass cons by sending superclass and subclass values
		Chield obj=new Chield(100,200,300,400,500);
	    }	
	}


