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
	 /****************************************************************************************************************************************/
	public void deleteBook() {
		Scanner sc = null;
		int choiseNo = 0;
		sc = new Scanner(System.in);
		String choiseFlag = null;
		System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
		System.out.println("\t \t \t \t \t \t  On which Details You want to Delete Book   ");
		System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
		// SHOW MENU
		System.out.println("\t\t\t\t\t\t 1. Delete Based On Id ");
		System.out.println("\t\t\t\t\t\t 2. Delete Based On Name ");
		System.out.println("\t\t\t\t\t\t 3. Delete Based On Authores Name ");
		System.out.println("\t\t\t\t\t\t 4. Delete Based On Price ");
		System.out.println("\t\t\t\t\t\t 5. Exit ");
		System.out.println();
		System.out.println("\t\t\t\t\t\t Enter Your Choise  - ");
		choiseNo = sc.nextInt();

		switch (choiseNo) {
		case 1:
			deleteById();
			break;
		case 2:
			deleteByName();
			break;
		case 3:
			deleteByAuthorsName();
			break;
		case 4:
			deleteByPrice();
			break;
		case 5:
			System.out.println("Thank you .......for Utilizing our Service");
			break;
		}// switch
	}// searchbook     
	/****************************************************************************************************************************************/
	// deleteById
	public void deleteById() {
            Scanner sc=null;
            String bid=null;
            sc=new Scanner(System.in);
            System.out.println("Enter Book Id ");
            bid=sc.next();
            for(Book bk:bookList) {
            	  if(bk.getBid().equalsIgnoreCase(bid)) {
            		 boolean flag= bookList.remove(bid);
            		  if(flag) {
            	       		 System.out.println("Book Deleted Sucessfully!!!!!!!!!!!!!!!!");
            	           		   }else {
            	           			 System.out.println("Record not deleted ");
            	           		   }
            	  }//else
            	/*  else {
             		    System.out.println(" there is no Book Record found For the given Id ");
             	  }//else   */  
            }//for
	}// deleteById 
	/****************************************************************************************************************************************/
	// deleteByName
	public void deleteByName() {
		   Scanner sc=null;
           String bName=null;
           sc=new Scanner(System.in);
           System.out.println("Enter Book Name ");
           bName=sc.next();
           for(Book bk:bookList) {
           	  if(bk.getBookNam().equalsIgnoreCase(bName)) {
           		boolean flag=bookList.remove(bName);
           		   if(flag) {
       		 System.out.println("Book Deleted Sucessfully!!!!!!!!!!!!!!!!");
           		   }else {
           			 System.out.println("Record not deleted ");
           		   }
           		    // System.out.println("\t \t \t ----------------------------------------------------------------------   \t\t \t ");
           	  }//if
           	  else {
           		    System.out.println(" there is no Book Record found For the given Name ");
           	  }//else
           }//for
	}// deleteByName
	/****************************************************************************************************************************************/
	// deleteByAuthorsName
	public void deleteByAuthorsName() {
		   Scanner sc=null;
           String[] authores =null;
            String authName=null;
           sc=new Scanner(System.in);
           System.out.println("Enter Book Authores Name One/More ");
           authName=sc.next();
           for(Book bk:bookList) {
           /*	  if(bk.getBookPrice()==price) {
           		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
           		  System.out.println("\t \t \t \t \t  Book Details ");
           		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
           		     System.out.println("\t\t\t  Book Id : -  \t\t\t\t \t \t \t "+bk.getBid());
           		     System.out.println("\t\t\t  Book Name : -  \t\t\t\t \t"+bk.getBookNam());
           		     System.out.println("\t\t\t  Book Price : -  \t\t\t\t \t"+bk.getBookPrice());
           		     System.out.println("\t\t\t  Book Authors Names  : -  \t\t\t\t \t "+Arrays.toString(bk.getAuthoresName()));
           		     System.out.println("\t \t \t ----------------------------------------------------------------------   \t\t \t "); 
           	  }//if   */
        	   if(bk!=null) {
        		   authores=bk.getAuthoresName();
        		   //
        		   for(String str: authores) {
        			     if(str.equalsIgnoreCase(authName)) {
        			    	 boolean flag= bookList.remove(str);
                   		  if(flag) {
                   	       		 System.out.println("Book Deleted Sucessfully!!!!!!!!!!!!!!!!");
                   	           		   }else {
                   	           			 System.out.println("Record not deleted ");
                   	           		   }
        			    	  }//if
        			     else {
        			    	 System.out.println(" \t\t\t\t There is no book to show ");
        			    	 break;
        			     }//else
        		   }//for
        	   }//if
           	  else {
           		    System.out.println(" there is no Book Record found For the given Authores   ");
           	  }//else
           }//for
	}// deleteByAuthorsName
	/****************************************************************************************************************************************/
	// deleteByPrice
	public void deleteByPrice() {
		   Scanner sc=null;
           float price=0.0f;;
           sc=new Scanner(System.in);
           System.out.println("Enter Book price  ");
           price=sc.nextFloat();
           for(Book bk:bookList) {
           	  if(bk.getBookPrice()==price) {
           		boolean flag=bookList.remove(price);
        		   if(flag) {
    		 System.out.println("Book Deleted Sucessfully!!!!!!!!!!!!!!!!");
        		   }else {
        			 System.out.println("Record not deleted ");
        		   }
           		  }//if
           	  else {
           		    System.out.println(" there is no Book Record found For the given Price  ");
           	  }//else
           }//for
	}//deleteByPrice
}//class
