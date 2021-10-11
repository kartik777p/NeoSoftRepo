package com.neosoft.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.neosoft.besics.Devloper;
import com.neosoft.besics.Intern;

public class InternTest {

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
		System.out.println("Enter  probation");
		int proba=sc.nextInt();
		System.out.println("Enter Certification");
		String certification=sc.next();
		ArrayList<Intern> list=new ArrayList<Intern>();
		Intern intrn=null;
		for(int i=0;i<n;i++) {
			intrn=new Intern();
			intrn.setId(id);
			intrn.setName(name);
			intrn.setDeptNo(dept);
			intrn.setSal(sal);
			intrn.setProbation(proba);
			intrn.setCertification(certification);
			//add to list
			list.add(intrn);
		}//for
		
		for(Intern i:list) {
			if(i.getSal()<=10000) {
				i.showId();
				i.showProfile();
			i.showStatus();
			}
			else {
				System.out.println("No Intern have less than 10K sal");
			}
		}
		

	}

}
