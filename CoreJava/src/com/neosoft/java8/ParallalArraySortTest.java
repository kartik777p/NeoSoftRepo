package com.neosoft.java8;

import java.util.Arrays;

public class ParallalArraySortTest {

	public static void main(String[] args) {
		int []  numbers= {10,30,40,70,60,50,6,8,55,44,88,33,22};
		//parallal sort
		Arrays.parallelSort(numbers);  //int
		//print array (all array)
		Arrays.stream(numbers).forEach(s-> System.out.print(" "+s));
	//	Arrays.stream(numbers).forEach(System.out::println);
		System.out.println("\n------------------------------------------------");
		//for specific location Sorting also allowed
		int []  numbers2= {10,30,40,70,60,50,6,8,55,44,88,33,22};
		Arrays.parallelSort(numbers2); 
		Arrays.stream(numbers2,1,5).forEach(s ->System.out.print(" "+s));
		

	}

}
