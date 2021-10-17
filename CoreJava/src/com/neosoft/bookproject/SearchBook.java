package com.neosoft.bookproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchBook {
	ArrayList<Book> Books = AddBook.getBookLists(); // get all list of books

	public void searchBook() {
		Scanner sc = null;
		int choiseNo = 0;
		sc = new Scanner(System.in);
		String choiseFlag = null;
		System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
		System.out.println("\t \t \t \t \t \t  On which Details You want to Search Book   ");
		System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
		// SHOW MENU
		System.out.println("\t\t\t\t\t\t 1. Search Based On Id ");
		System.out.println("\t\t\t\t\t\t 2. Search Based On Name ");
		System.out.println("\t\t\t\t\t\t 3. Search Based On Authores Name ");
		System.out.println("\t\t\t\t\t\t 4. Search Based On Price ");
		System.out.println("\t\t\t\t\t\t 5. Search Based On Price Range Min/Max ");
		
		System.out.println("\t\t\t\t\t\t 6. Exit ");
		System.out.println();
		System.out.println("\t\t\t\t\t\t Enter Your Choise  - ");
		choiseNo = sc.nextInt();

		switch (choiseNo) {
		case 1:
			searchById();
			break;
		case 2:
			searchByName();
			break;
		case 3:
			searchByAuthorsName();
			break;
		case 4:
			searchByPrice();
			break;
		case 5:
			searchByPriceRange();
			break;
		case 6:
			System.out.println("Thank you .......for Utilizing our Service");
			break;
		}// switch
	}// searchbook
	 /*************************************************************searchById**************************************************************************/
	// searchById
	public void searchById() {
            Scanner sc=null;
            String bid=null;
            sc=new Scanner(System.in);
            System.out.println("Enter Book Id ");
            bid=sc.next();
            for(Book bk:Books) {
            	  if(bk.getBid().equalsIgnoreCase(bid)) {
            		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
            		  System.out.println("\t \t \t \t \t  Book Details ");
            		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
            		     System.out.println("\t\t\t  Book Id : -  \t\t\t\t \t \t \t "+bk.getBid());
            		     System.out.println("\t\t\t  Book Name : -  \t\t\t\t \t"+bk.getBookNam());
            		     System.out.println("\t\t\t  Book Price : -  \t\t\t\t \t"+bk.getBookPrice());
            		     System.out.println("\t\t\t  Book Authors Names  : -  \t\t\t\t \t "+Arrays.toString(bk.getAuthoresName()));
            		     System.out.println();
            		   //  System.out.println("\t \t \t ----------------------------------------------------------------------   \t\t \t ");
            	  }//else
            	  else {
             		 try {
             			 throw new BookNotFoundException("book not Found to SearchBy Id");
             		 }catch (BookNotFoundException bnf) {
						bnf.printStackTrace();
					}//catch
             	  }//else
            }//for
	}// searchById
	 /****************************************************searchByName***********************************************************************************/
	// searchByName
	public void searchByName() {
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
         			 throw new BookNotFoundException("book not Found to SearchBy Name");
         		 }catch (BookNotFoundException bnf) {
					bnf.printStackTrace();
				}//catch
           		 }//else
           }//for
	}// searchByName
	 /****************************************************searchByAuthorsName************************************************************************************/
	// searchByAuthorsName
	public void searchByAuthorsName() {
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
                     			 throw new BookNotFoundException("book not Found to SearchBy Authores");
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
	}// searchByAuthorsName
	 /*****************************************************searchByPrice***********************************************************************************/
	// searchByPrice
	public void searchByPrice() {
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
         			 throw new BookNotFoundException("book not Found to SearchBy Price ");
         		 }catch (BookNotFoundException bnf) {
					bnf.printStackTrace();
				}//catch
           	  }//else
           }//for
	}// searchByPrice
	 /****************************************************searchByPriceRange************************************************************************************/
	 public void searchByPriceRange() {
		 Scanner sc=null;
		 float minAmt,maxAmt=0.0f;
		 sc=new Scanner(System.in);
		  System.out.println("Enter the Minimum Price ");
		  minAmt=sc.nextFloat();
		  System.out.println("Enter the Maximum Price ");
          maxAmt=sc.nextFloat();
          for(Book bk:Books) {
        	   if((bk.getBookPrice()>=minAmt) && (bk.getBookPrice()<=maxAmt)) {
        		   System.out.println("\t\t\t ----------------------------------------------------------------------------");
         		  System.out.println("\t \t \t \t \t  Book Details ");
         		  System.out.println("\t\t\t ----------------------------------------------------------------------------");
         		     System.out.println("\t\t\t  Book Id : -  \t\t\t\t \t \t \t "+bk.getBid());
         		     System.out.println("\t\t\t  Book Name : -  \t\t\t\t \t"+bk.getBookNam());
         		     System.out.println("\t\t\t  Book Price : -  \t\t\t\t \t"+bk.getBookPrice());
         		     System.out.println("\t\t\t  Book Authors Names  : -  \t\t\t\t \t "+Arrays.toString(bk.getAuthoresName()));
         		     System.out.println();
        	   }//if
        	   else {
        		   try {
           			 throw new BookNotFoundException("book not Found to SearchBy By given Range ");
           		 }catch (BookNotFoundException bnf) {
						bnf.printStackTrace();
					}//catch
        	   }//else 
          }//for
	 }//searchByPriceRange
}// class
