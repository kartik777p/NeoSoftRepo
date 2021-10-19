package com.neosoft.bookproject;

import java.util.ArrayList;
import java.util.Iterator;
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
			//deleteByAuthorsName();
			break;
		case 4:
			deleteByPrice();
			break;
		case 5:
			System.out.println("Thank you .......for Utilizing our Service");
			break;
		}// switch
	}// search book     
	 /********************************************************deleteById*******************************************************************************/
	// deleteById
	public void deleteById() {
            Scanner sc=null;
            String bid=null;
          //  boolean flag=false;
            String foundFlag="false";
            Iterator<Book> itr=null;
           // String id=null;
          // Book book=null;
            sc=new Scanner(System.in);
            System.out.println("Enter Book Id ");
            bid=sc.next();
            itr=Books.iterator();
            while(itr.hasNext()) {
            	Book bk=itr.next();
            	if(bk.getBid().equalsIgnoreCase(bid)) {
            		//id=bk.getBid();
            		//book=bk;
            		System.out.println();
            		System.out.println(" \t Book Found");
            		foundFlag="found";
            		System.out.println(bk);
            		 itr.remove();
            		break;
            	}//if
            }//while
            if(foundFlag=="false") {
    		try {
    		throw new BookNotFoundException("For the given id Book not found ");
    		}catch (Exception e) {
				e.printStackTrace();
			}//catch
    	}//else if
               
	}//deleteById
	
            //remove that book from the collections
          /*  for(Book bk:Books) {
            	if(bk.getBid().equalsIgnoreCase(bid)) {
            		flag=Books.remove(bk);
            		System.out.println(flag);
            		if(flag==true)
            			   System.out.println("Book has been Removed ");
            		else
            			System.out.println("There is some Problem to Deleting this book  ");
            	}//if
            	/*else if(flag!=true) {
            		//no need of else bcz we have allready thrown exception above if book is not there
            	}  
            }//for*/
			/*
			 * System.out.println(Books.size()); for(Book bk:Books) {
			 * if(bk.getBid().equalsIgnoreCase(bid)) { flag=Books.remove(bid); //commit to
			 * real object AddBook.setBookLists(Books); //
			 * System.out.println("Book Deleted Sucessfully!!!!!!!!!!!!!!!!"); }//if else
			 * if(flag!=true) { try { throw new
			 * BookNotFoundException("book not Found to delete By Id "); }catch
			 * (BookNotFoundException bnf) { bnf.printStackTrace(); }//catch }//else }//for
			 	}// deleteById */
	/********************************************************deleteByName *******************************************************************************/
	// deleteByName
	public void deleteByName(){
	 Scanner sc=null;
		String bName=null;
		 // boolean flag=false;
          String foundFlag="false";
          Iterator<Book> itr=null;
		sc=new Scanner(System.in);
		System.out.println("Enter a Book Name ");
		bName=sc.next();
		//check that book is availbale or not
		  itr=Books.iterator();
          while(itr.hasNext()) {
          	Book bk=itr.next();
			if(bk.getBookNam().equalsIgnoreCase(bName)) {
				foundFlag="found";
				   System.out.println();
				   System.out.println("\t Book Found");
				   System.out.println(bk);
				   itr.remove();
			}//if
		}//for
           if(foundFlag!="false") {
				try {
					throw new BookNotFoundException("For The Given Name No Book Found ");
				}catch (Exception e) {
					e.printStackTrace();
				  }//catch
				}//if
	}// deleteByName
	/********************************************************deleteByAuthorsName*******************************************************************************/
	// deleteByAuthorsName
	/*public void deleteByAuthorsName() {
		 Scanner sc=null;
			String authNames[]=null;
			String authName=null;
			int authNo=0;
			 // boolean flag=false;
	          String foundFlag="false";
	          Iterator<Book> itr=null;
			sc=new Scanner(System.in);
			System.out.println("how many Authores Name you want to Enter ");
			authNo=sc.nextInt();
			//initialized array
			authNames=new String[authNo];
			  for(int i=0;i<authNo;i++) {
			System.out.println("Enter"+(i+1) +"Authore  Name ");
			authNames[i]=sc.next();
			  }
			
			//check that book is availbale or not
			for(Book bk:Books) {
				
			}//for 
			 itr=Books.iterator();
	         while(itr.hasNext()) {
	      	   Book bk=itr.next();
	      	   if(bk.getBookNam().equalsIgnoreCase(bName)) {
	      		   itr.remove();
	      		  System.out.println("Book Removed ");
	      	   }else {
	      		   System.out.println("There is a some problem while removing the book ");
	      	   }//else
	         }//while
		
	}// deleteByAuthorsName   */
	/********************************************************deleteByPrice*******************************************************************************/
	// deleteByPrice
	public void deleteByPrice() {
		Scanner sc=null;
		float price=0.0f;
		 // boolean flag=false;
          String foundFlag="false";
          Iterator<Book> itr=null;
		sc=new Scanner(System.in);
		System.out.println("Enter a Book Price  ");
		price=sc.nextFloat();
		//check that book is availbale or not
		for(Book bk:Books) {
			if(bk.getBookPrice()==price) {
				foundFlag="found";
				   System.out.println();
				   System.out.println("\t Book Found");
				   System.out.println();
			}else if(foundFlag!="found") {
				try {
					throw new BookNotFoundException("For The Given Name No Book Found ");
				}catch (Exception e) {
					e.printStackTrace();
				  }//catch
				}//else
		}//for 
		 itr=Books.iterator();
         while(itr.hasNext()) {
      	   Book bk=itr.next();
      	   if(bk.getBookPrice()==price) {
      		   itr.remove();
      		  System.out.println(" \t \t Book Removed ");
      	   }else {
      		   System.out.println(" \t \t There is a some problem while removing the book ");
      	   }//else
         }//while
	}//deleteByPrice
}//class
