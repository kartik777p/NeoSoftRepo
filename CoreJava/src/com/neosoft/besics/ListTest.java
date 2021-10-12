package com.neosoft.besics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		//create arraylist
		List<StudentL> students=new ArrayList();
     //add students
		students.add(new StudentL(11,"kartik","java",80));
		students.add(new StudentL(12,"shubh","C#",70));
		students.add(new StudentL(13,"ravi","php",90));
		students.add(new StudentL(14,"saurabh","python",40));
		students.add(new StudentL(15,"shubh","java",80));
	   //get etrator
		Iterator<StudentL> itr =students.iterator();
		//itrate records
		System.out.println(" using Iterator ");
		while(itr.hasNext()) {
			StudentL str=itr.next();
			//display record(override To string in student)
			System.out.println(str);
		}
		//now add new obj to position 1   (shift to left)
		students.add(1, new StudentL(16,"mp",".net",50));   //add new object to position 1
		students.add( new StudentL(17,"sp",".java",10));   //add at the end 
		//remove one object 
		students.remove(1);   //remove 1st index obj that is 16,"mp",".net",50
		System.out.println();
		//itrate using inhance for
		System.out.println(" Using Inhanced for loop");
		for(StudentL s:students) {
			System.out.println(s);
		}
		//clear students
		students.clear();
		System.out.println("------------------------------------------------------------------");
		
		ArrayList<Object> complexList=new ArrayList<Object>(Arrays.asList(null,"kp",101,10.6,true));
		 //to add more collectionss(must have allredy collction)
		complexList.addAll(Arrays.asList(104,false,10,20,40,60));  //add at the end 
		
		/*//etrator using inhance or
		int sum=0;
		 for(Object obj: complexList) {
			  System.out.println(obj);
			  String str="java.lang.Integer";
			  int num=0;
			  if(obj!=null) {
				  if(obj.getClass().equals(str)){
					  num=(Integer)obj;
					  sum=sum+num;
				  }//if
			  }//if
		 }//for
	
		 System.out.println(" sum is ::- "+sum);
		 	 */
		int  sum=0;
		for(Object obj: complexList) {
			if(obj instanceof Integer) {
				sum=sum+Integer.parseInt(obj.toString());
			}
			  System.out.println(obj);
		}
		System.out.println("Sum of integer is ::- "+sum);
		 //to find big numbr 
		 System.out.println("Big number :"+Collections.max(new ArrayList<Integer>(Arrays.asList(10,20,30,50,80))));
		 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		 
		 //LinkedList
		 LinkedList<Object> complexLinkedList=new LinkedList(Arrays.asList(null,"kp",101,10.6,true));
		  //add to list
		 complexLinkedList.addFirst("shubh");  //at the end
		 //add to 2nd 
		 complexLinkedList.add(2,1.8);
		 //use of RemoveLast(remove and give value)
		 System.out.println("---------------------------------------");
		 System.out.println(complexLinkedList.removeLast());   //remove and print
		 System.out.println("---------------------------------------");
		 System.out.println(complexLinkedList.getLast()); //only print
		  System.out.println("----------------------------------------------------");
		 for(Object lst: complexLinkedList) {
			 System.out.println(lst);
		 }
		 //clear linkedList
		 complexLinkedList.clear();
		 
	}///main
}//class

//
class StudentL{
	private int sno;
	private String sname;
	private String course;
	private int marks;
	//cons
	public StudentL(int sno, String sname, String course, int marks) {
		this.sno = sno;
		this.sname = sname;
		this.course = course;
		this.marks = marks;
	}
	//toString
	@Override
	public String toString() {
		return "StudentL [sno=" + sno + ", sname=" + sname + ", course=" + course + ", marks=" + marks + "]";
	}
}
