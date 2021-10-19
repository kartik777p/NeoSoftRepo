package com.neosoft.bookproject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddBook {
	//create arraylist obj having initial capacity  (10)
	     private static ArrayList<Book> bookList=new ArrayList<Book>();
	     
	     //static method to retun arrayList 
	     public static ArrayList<Book> getBookLists(){
	    	   return bookList;
	     }  
	     //static set method
	     public static void setBookLists(ArrayList<Book> booklist){
	    	 bookList=booklist;
	     }  
	public void addBook() {
		//declaration
		     Scanner sc=null;
		     String bid,bName=null;
		     float price=0.0f;
		     String [] authors=null;
		     int authNo=0;
		     Book book=null;
		     ObjectOutputStream oos=null;
		     String outFile=null;
		     
		     //Initialization and logic 
		       sc=new Scanner(System.in);
		       System.out.println("Enter Book id :- ");
		       bid=sc.next();
		       System.out.println("Enter Book Name :- ");
		       bName=sc.next();
		       System.out.println("Enter book Price  :- ");
              price=sc.nextFloat();
              System.out.println("Enter the Number of Authors :- ");
              authNo=sc.nextInt();
              authors=new String[authNo];
              //read values and store into array
              for(int i=0;i<authNo;i++) {
            	  System.out.println("Enter "+(i+1)+" Name :- ");
            	  authors[i]=sc.next();
              }
              //set values to Book class Object
              book=new Book(bid, bName, price, authors);
              //now add that book to ArrayList
              bookList.add(book);
              //also save book to file
              //locate file
              outFile="Resources/BookDetails.txt";
              //create oos object having file
              try {
              oos=new ObjectOutputStream(new FileOutputStream(outFile));
                //now write object to file
                for(Book bk :bookList) {
                	oos.writeObject(bk);
                }
              }//try
              catch (Exception e) {
				e.printStackTrace();
			}//catch
              System.out.println("\t \t \t \t \t \t------------------------------------------------");
              System.out.println("\t \t \t \t \t \t Book Added Sucessfully!!!!!!!!!!!!!!!");
              System.out.println("\t \t \t \t \t \t------------------------------------------------");
	}//addbook

}//class
