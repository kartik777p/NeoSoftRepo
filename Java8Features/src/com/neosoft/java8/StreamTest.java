package com.neosoft.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(new Mobile(101, "samsung", 1500));
		mobiles.add(new Mobile(102, "Redmi", 1800));
		mobiles.add(new Mobile(103, "Realme", 1300));
		mobiles.add(new Mobile(104, "Apple", 40000));

		// filter store in another list and print that
		System.out.println("--------------------Store to diff list ------------- ");
		List<String> mobilePhones = mobiles.stream().filter((mobile) -> mobile.price < 40000) // filter
				.map(mobile -> mobile.name) // mobile name only
				.collect(Collectors.toList());       //as a list
		// print mobile Name
		System.out.println(mobilePhones);
		//mobiles.clear();
		System.out.println("-------------only print------------------ ");
		// dont want to store only print
		mobiles.stream().filter(mobile -> mobile.price < 40000)
				.forEach(mobile -> System.out.println(mobile.name));
		
		//max price                                                                                                      //here we use ternarry operator if big then 1 if small then -1
	  Mobile m1=mobiles.stream().max((mob1 ,mob2) -> mob1.price    > mob2.price ? 1 : -1).get();                      //here we wont find compairTo bcz that  method Availble forWrapper type only and in mobile class we have taken all premitive
		//get the max  price
	  System.out.println("Max Price is :- "+m1.price);
	  
		// min price
	  Mobile m2=mobiles.stream().min((mob1 ,mob2) -> mob1.price    >  mob2.price ? 1 : -1).get();
	//get the min  price
	  System.out.println("Min Price is :- "+m2.price);
	  
		//count phone which have 14000+
	  long count=mobiles.stream().filter(mobile -> mobile.price>1400).count(); //long return type   
	  System.out.println("Counter : "+count);
	  
	  //Accumrate result as a Set
	  Set<Double> mobilePrices=mobiles.stream().filter(mobile -> mobile.price>14000).map(mobile -> mobile.price) //only price 
			  .collect(Collectors.toSet());
	  System.out.println(mobilePrices);
	//Accumrate result as a Map
	  Map<Integer, String> mobileMap = mobiles.stream().filter(mobile -> mobile.price > 14000) // filter data				
				.collect(Collectors.toMap(mobile -> mobile.id, mobile -> mobile.name));
		System.out.println(mobileMap);
		/*Map<Integer,String> mobileMap1=mobiles.stream().filter(mobile -> mobile.price>14000).collect(Collectors.toMap(mobile -> mobile.id, mobile->mobile.name));
		System.out.println(mobileMap1);   */
	}

}
