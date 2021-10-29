package com.neosoft.sessiontask;

import java.util.Scanner;

public class S1_Student {

	static int stid;
	static String name;
	static String course;
	static int marks;
   
	//cons
	public S1_Student(int thestid, String thename, String thecourse, int themarks) {
		this.stid = thestid;
		this.name = thename;
		this.course = thecourse;
		this.marks = themarks;
	}//cons

	public void show() {
		//System.out.println("Student Id:" + stid + "Student Name:" + name + "Course :" + course + "Marks :" + marks);
		if (S1_Student.course=="BCA"&&S1_Student.marks>60) {
		 System.out.println("Student Id:"+stid+"Student Name:"+name+"Course:" + course + "Marks :" + marks);
		}
	}//show

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Enter the number of student");
		int n, i;
		String thecourse;
		int themarks;
		n = sc1.nextInt();
		S1_Student st[] = new S1_Student[n];
		for (i = 0; i < n; i++) {
            
			System.out.println("Enter your Id:");
			int thestid = sc1.nextInt();
			System.out.println("Enter your Name:");
			String thename = sc1.next();
			System.out.println("Enter your Course:");
		 thecourse = sc1.next();
			System.out.println("Enter your Marks:");
			themarks = sc1.nextInt();
			st[i] = new S1_Student(thestid, thename, thecourse, themarks);
			// st[i].show();
		}//for
		for (int j = 0; j < st.length; j++) {
		     st[j].show();
		}//for
	}//main
}//class
