package com.neosoft.bankproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class BankAccount implements Serializable {
	
	//property
	private static String bankName;
	private String AccNumber;
	private String name;
	private String add;
	private String cno;
	private  String uname;
	private String pwd;
	private float dep;
	private float amt;
	private  String type;
	//cons
	public BankAccount() {
		//empty
	}
	//param cons
	public BankAccount(String AccNumber,String name, String add, String cno, String uname, String pwd, float dep,
			String type) {
		this.AccNumber=AccNumber;
		this.name = name;
		this.add = add;
		this.cno = cno;
		this.uname = uname;
		this.pwd = pwd;
		this.dep = dep;
		this.amt = dep;
		this.type = type;
	}
	//private static method
	public static  void setBankName(String name) {
		bankName=name;
	}
	//get bankName
	public static  String getBankName() {
		return bankName;
	}
	
	//getters stters
	public String getAccNumber() {
		return AccNumber;
	}
	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public float getDep() {
		return dep;
	}
	public void setDep(float dep) {
		this.dep = dep;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//toString
	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", add=" + add + ", cno=" + cno + ", uname=" + uname + ", pwd=" + pwd
				+ ", dep=" + dep + ", amt=" + amt + ", type=" + type + "]";
	}//toString
	
}//class
