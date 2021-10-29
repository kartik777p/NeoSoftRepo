package com.neosoft.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTest {

	public static void main(String[] args) {
		//create list of students
		List<Student> students=new ArrayList<>();
		//add student to list
		students.add(new Student(101, 90));
		students.add(new Student(102, 80));
		students.add(new Student(103, 50));
		students.add(new Student(104, 60));
		students.add(new Student(105, 70));
		  
		//we have to find sum of the given mark
		   int  sum_Marks= students.stream().collect(Collectors.summingInt(st -> st.marks));   //return type int
		   System.out.println("sum of the students marks is :- "+sum_Marks);
		   
		   //now we have to calculate the avg of the given marks
		    double avg_marks=students.stream().collect(Collectors.averagingDouble(std ->std.marks));
		    System.out.println("avg of the students marks is :-"+avg_marks);
		    
		    //now we have to calculate the summary of the students marks 
		     //directly print samury
		    System.out.println(students.stream().collect(Collectors.summarizingInt(std -> std.marks)));
		    //groupingby
		    System.out.println(students.stream().collect(Collectors.groupingBy(std -> std.marks)));
		    //groupingby With count (it will give you a counting of the marks like 80 marks have only 1 student
		    System.out.println(students.stream().collect(Collectors.groupingBy(std -> std.marks,Collectors.counting())));
		 /* 
		  int total_Marks = students.stream().collect(Collectors.summingInt(st -> st.marks)); 
		  System.out.println("Total Marks: "+total_Marks);
		
		  double avg_Marks = students.stream().collect(Collectors.averagingDouble(st ->
		  st.marks)); System.out.println("Avg Marks: "+avg_Marks);
		  
		  System.out.println(students.stream().collect(Collectors.summarizingInt(st ->
		  st.marks)));
		  
		  System.out.println(students.stream().collect(Collectors.groupingBy(st -> st.marks)));
		  System.out.println(students.stream().collect(Collectors.groupingBy(st -> st.marks,Collectors.counting())));
		     */
		 }

}

class Student{
	  int id;
	  int marks;
	  //cons
	public Student(int id, int marks) {
		this.id = id;
		this.marks = marks;
	}
	  
}
