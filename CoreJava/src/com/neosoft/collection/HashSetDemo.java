package com.neosoft.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	public static void main(String[] args) {
		// store employee Names
		 HashSet<String> hs=new HashSet<String>();
    //print
		 System.out.println(hs);
		 //add names
		 hs.add("kartik");
		 hs.add("shubh");
		 hs.add("saurabh");
		 hs.add("kartik");
		 hs.add("hari");
		 hs.add("ravi");
		 hs.add("shiv");
		 hs.add("kiran");
		 System.out.println(hs);
		//we can not use for loop here bcz there is o indexing
		//inhanced for loop
		 System.out.println("--------Inhanced For Loop-----------");
		 for(String name:hs) {
			 System.out.println(name);
		 }
		 //for each
		 System.out.println("--------Using for Each------------");
		hs.forEach(nm->System.out.println(nm));
		//using itrator
	    System.out.println("--------Using Iterator");
	    Iterator<String> itr=hs.iterator();
	    while(itr.hasNext()) {
	    	String name=itr.next();
	    	System.out.println(name);
	    }
	    //we can add element at the end only bcz there is no indexing
	    hs.add("dipali");
	    System.out.println(hs);
	}//main
   }//class
