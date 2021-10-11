package com.neosoft.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.neosoft.besics.Devloper;

public class DeloperTest {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("how many record dp you want to save");
		int n=sc.nextInt();
		System.out.println(" Enter id  ");
		int id=sc.nextInt();
		System.out.println(" Enter Name ");
		String name=sc.next();
		System.out.println("Enter dept ");
		int dept=sc.nextInt();
		System.out.println("Enter salary ");
		double sal=sc.nextDouble();
		System.out.println("Enter skills ");
		String skills=sc.next();
		System.out.println("Enter project name ");
		String pName=sc.next();
		
		ArrayList<Devloper> list=new ArrayList<Devloper>();
		Devloper dev1=null;
		for(int i=0;i<n;i++) {
			  dev1=new Devloper();
			dev1.setId(id);
			dev1.setName(name);
			dev1.setDeptNo(dept);
			dev1.setSal(sal);
			dev1.setProjectName(pName);
			dev1.setSkills(skills);
			//add obj to array list
			list.add(dev1);
		}
		
		for(Devloper d:list) {
			if(d.getSal()<=10000) {
				d.showId();
			d.showProfile();
			}
			else {
				System.out.println("No devloper have less than 10K sal");
			}
		}
		
		
		
		
	}

}
