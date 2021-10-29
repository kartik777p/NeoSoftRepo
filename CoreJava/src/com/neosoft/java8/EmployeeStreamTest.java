package com.neosoft.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreamTest {

	public static void main(String[] args) {
	List<Employee> employees=new ArrayList<>();
    //add emps
	employees.add(new Employee(102,"shubh",20000));     //s3
	employees.add(new Employee(104,"shiv",60000));
	employees.add(new Employee(101,"kartik",10000));      //k1
	employees.add(new Employee(103,"maddy",40000));     //m2
	employees.add(new Employee(105,"mp",80000));
	
	List<Employee> newFilterList=employees.stream().filter(emp -> emp.getSalary()<45000).collect(Collectors.toList());
	//sort emp by the sal
	Collections.sort(newFilterList, (e1,e2)->e1.name.compareTo(e2.name));  //sort    comparator object(2nd)param
	 //
	newFilterList.forEach(emp -> System.out.println(emp.name));
	
	System.out.println("-------------------------------------------------------------------------------------------");
	/*employees.stream().filter(em->em.esal<45000)
	  .sorted((employee1,employee2)->employee1.ename.compareTo(employee2.ename)).forEach(ele->System.out.println(ele.ename));;
 */
	
	}

}
