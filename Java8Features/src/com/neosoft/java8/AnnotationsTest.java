package com.neosoft.java8;

import java.util.ArrayList;

public class AnnotationsTest {

	@SuppressWarnings({"unchecked","rawtypes"})
	public static void main(String[] args) {
		ArrayList a=new ArrayList<>();
		a.add("a");
		a.add("b");
		a.add("c");
		System.out.println(a);
	}
}

class Parent{
	public void show() {
		System.out.println("hiiiii Parent show method....");
	}
}


class Child extends Parent{
	@Override   //infrom to compiler
	public void show() {
		System.out.println("hiiiii Child show method....");
	}
}

class Google{
	@Deprecated
	 public void search(){
		 System.out.println("Google.search()");
	 }
}
