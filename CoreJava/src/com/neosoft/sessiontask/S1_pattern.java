package com.neosoft.sessiontask;
import java.util.*;
public class S1_pattern {

	public static void main(String[] args) {
		Scanner  sc=new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int row=sc.nextInt();
		int c=1;
		for (int i=1;i<=row;i++)   //for row
		{
			for(int k=row-1;k>=i;k--)   //for Space
			{
				System.out.print(" ");
			}
			
			for (int j=1;j<=i;j++)  //for printing values
			{
				System.out.print(" "+c);
				c++;
			}
			System.out.println(" ");
		}//for
	}//main
}//class
