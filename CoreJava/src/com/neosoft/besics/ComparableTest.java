package com.neosoft.besics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Candidate> candidates=new ArrayList();
	     //add students
		candidates.add(new Candidate(11,"kartik","java",80));
		candidates.add(new Candidate(12,"shubh","C#",70));
		candidates.add(new Candidate(13,"ravi","php",90));
		candidates.add(new Candidate(14,"saurabh","python",40));
		candidates.add(new Candidate(15,"shubh","java",80));
	  /*	//sort the candidate
		Collections.sort(candidates); // normal sorting ----->
		//print in normal
		System.out.println("----------------------------------Normal sorting -------------------------------------------------");
		for(Candidate candidate:candidates) {
			System.out.println(candidate);
		}
		System.out.println("----------------------------------Reverse  sorting---------------------------------------------------");
		//sort in reverse order
		Collections.sort(candidates,Collections.reverseOrder());//reverse sorting 
		// print each sorted record
		for(Candidate candidate:candidates) {
			System.out.println(candidate);
		}
		*/
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		 Candidate can1=Collections.min(candidates);
		 Candidate can2=Collections.max(candidates);
		  System.out.println("min number :- "+can1);
		  System.out.println(" max number :- "+can2);
		 
	}//main
}//class

class Candidate implements Comparable<Candidate>{
	private int sno;
	private String sname;
	private String course;
	private int marks;
	//cons
	public Candidate(int sno, String sname, String course, int marks) {
		this.sno = sno;
		this.sname = sname;
		this.course = course;
		this.marks = marks;
	}
	//toString
	@Override
	public String toString() {
		return "Candidate [sno=" + sno + ", sname=" + sname + ", course=" + course + ", marks=" + marks + "]";
	}
	/*@Override    //compair using marks
	public int compareTo(Candidate o) {
		if(this.marks==o.marks) {
			return 0;
		}else if(this.marks>o.marks) {
			return 1;
		}
		else {
			return -1;
		}
	}//method
	*/
	@Override
	public int compareTo(Candidate o) {
		return this.marks - o.marks;  //  upper one is complecated  this one   shortest way
	}
}//class

