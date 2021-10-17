package com.neosoft.bookproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteBook {
	ArrayList<Book> Books = AddBook.getBookLists(); // get all list of books
	   //show menus
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
	 /********************************************************deleteById*******************************************************************************/
	// deleteById
	public void deleteById() {
            Scanner sc=null;
            String bid=null;
            sc=new Scanner(System.in);
            System.out.println("Enter Book Id ");
            bid=sc.next();
            for(Book bk:Books) {
            	  if(bk.getBid().equalsIgnoreCase(bid)) {
            		 Books.remove(bid);
            		 //commit to real object
            		 AddBook.setBookLists(Books);
            		 System.out.println("Book Deleted Sucessfully!!!!!!!!!!!!!!!!");
            	  }//if
            	 else {
            		 try {
	         			 throw new BookNotFoundException("book not Found to delete By Id ");
	         		 }catch (BookNotFoundException bnf) {
						bnf.printStackTrace();
					}//catch
             	  }//else   
            }//for
	}// deleteById 
	/********************************************************deleteByName*******************************************************************************/
	// deleteByName
	public void deleteByName() {
		   Scanner sc=null;
           String bName=null;
           sc=new Scanner(System.in);
           System.out.println("Enter Book Name ");
           bName=sc.next();
           for(Book bk:Books) {
           	  if(bk.getBookNam().equalsIgnoreCase(bName)) {
           		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
           		  System.out.println("\t \t \t \t \t  Book Details ");
           		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
           		     System.out.println("\t\t\t  Book Id : -  \t\t\t\t \t \t \t "+bk.getBid());
           		     System.out.println("\t\t\t  Book Name : -  \t\t\t\t \t"+bk.getBookNam());
           		     System.out.println("\t\t\t  Book Price : -  \t\t\t\t \t"+bk.getBookPrice());
           		     System.out.println("\t\t\t  Book Authors Names  : -  \t\t\t\t \t "+Arrays.toString(bk.getAuthoresName()));
           		   System.out.println();
           		    // System.out.println("\t \t \t ----------------------------------------------------------------------   \t\t \t ");
           	  }//if
           	  else {
           		 try {
         			 throw new BookNotFoundException("book not Found to delete  By Name ");
         		 }catch (BookNotFoundException bnf) {
					bnf.printStackTrace();
				}//catch
           	  }//else
           }//for
	}// deleteByName
	/********************************************************deleteByAuthorsName*******************************************************************************/
	// deleteByAuthorsName
	public void deleteByAuthorsName() {
		   Scanner sc=null;
           String[] authores =null;
            String authName=null;
           sc=new Scanner(System.in);
           System.out.println("Enter Book Authores Name One/More ");
           authName=sc.next();
           for(Book bk:Books) {
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
        			    	 System.out.println("\t\t\t ----------------------------------------------------------------------------");
        	           		  System.out.println("\t \t \t \t \t  Book Details ");
        	           		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
        	           		     System.out.println("\t\t\t  Book Id : -  \t\t\t\t \t \t \t\t\t "+bk.getBid());
        	           		     System.out.println("\t\t\t  Book Name : -  \t\t\t\t \t\t\t\t"+bk.getBookNam());
        	           		     System.out.println("\t\t\t  Book Price : -  \t\t\t\t \t\t\t\t"+bk.getBookPrice());
        	           		     System.out.println("\t\t\t  Book Authors Names  : -  \t\t\t\t \t "+Arrays.toString(bk.getAuthoresName()));
        	           		   System.out.println();
        	           		   //  System.out.println("\t \t \t ----------------------------------------------------------------------   \t\t \t ");
        	           		     }//if
        			     else {
        			    	 try {
        	         			 throw new BookNotFoundException("book not Found to Delete By Author Name");
        	         		 }catch (BookNotFoundException bnf) {
        						bnf.printStackTrace();
        					}//catch
        			    	 break;
        			     }//else
        		   }//for
        	   }//if
           	  else {
           		    System.out.println(" there is no Book Record found For the given Authores   ");
           	  }//else
           }//for
	}// deleteByAuthorsName
	/********************************************************deleteByPrice*******************************************************************************/
	// deleteByPrice
	public void deleteByPrice() {
		   Scanner sc=null;
           float price=0.0f;;
           sc=new Scanner(System.in);
           System.out.println("Enter Book price  ");
           price=sc.nextFloat();
           for(Book bk:Books) {
           	  if(bk.getBookPrice()==price) {
           		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
           		  System.out.println("\t \t \t \t \t  Book Details ");
           		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
           		     System.out.println("\t\t\t  Book Id : -  \t\t\t\t \t \t \t "+bk.getBid());
           		     System.out.println("\t\t\t  Book Name : -  \t\t\t\t \t"+bk.getBookNam());
           		     System.out.println("\t\t\t  Book Price : -  \t\t\t\t \t"+bk.getBookPrice());
           		     System.out.println("\t\t\t  Book Authors Names  : -  \t\t\t\t \t "+Arrays.toString(bk.getAuthoresName()));
           		   System.out.println();
           		   //  System.out.println("\t \t \t ----------------------------------------------------------------------   \t\t \t ");
           	  }//if
           	  else {
           		 try {
         			 throw new BookNotFoundException("book not Found to delete By Price  ");
         		 }catch (BookNotFoundException bnf) {
					bnf.printStackTrace();
				}//catch
           	  }//else
           }//for
	}//deleteByPrice
}//class
