package com.neosoft.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionTest2 {

	public static void main(String[] args) {
	   
	/*	//thread
		Runnable r=() ->{
			 for(int i=1;i<=10;i++) {
				 try {
					 System.out.println(i+" ");
					 Thread.sleep(500);
				 }catch (Exception e) {
					e.printStackTrace();
				}
			 }//for
		};
		//
		new Thread(r).start();
		
		
		List<Integer> list=new ArrayList<>();
		//add
		list.add(101);
		list.add(102);
		list.add(103);
		list.add(104);
		list.add(105);
		//itrate
		list.forEach((num) ->{
			if(num>102)            //filter 
				  System.out.print(num+" ");
		});	*/
		List<Mobile> mobiles=new ArrayList<Mobile>();
		mobiles.add(new Mobile(101, "samsung", 1500));
		mobiles.add(new Mobile(102, "Redmi", 1800));
		mobiles.add(new Mobile(103, "Realme", 1300));
		mobiles.add(new Mobile(104, "Apple", 40000));
		//sort by name   
		Collections.sort(mobiles, (m1,m2)-> m1.name.compareTo(m2.name));  //sort    comparator object(2nd)param
		  //for iterator
		mobiles.forEach((mobile) -> System.out.println(mobile.name));      //print mobile name 

		
		
		
	}

}

class Mobile{
	int id;
	String name;
	double price;
	public Mobile(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

