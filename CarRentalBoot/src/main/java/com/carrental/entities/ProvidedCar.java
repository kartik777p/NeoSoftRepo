package com.carrental.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetail")
public class ProvidedCar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String carno;
	private String useremail;
	private String username;
	private long usermobile;
	private String issuedate;
	private String returnstatus;

	public ProvidedCar() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getCarno() {
		return carno;
	}

	public String getUseremail() {
		return useremail;
	}

	public String getUsername() {
		return username;
	}

	public long getUsermobile() {
		return usermobile;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUsermobile(long usermobile) {
		this.usermobile = usermobile;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	@Override
	public String toString() {
		return "ProvidedCar [id=" + id + ", carno=" + carno + ", useremail=" + useremail + ", username=" + username
				+ ", usermobile=" + usermobile + ", issuedate=" + issuedate + ", returnstatus=" + returnstatus + "]";
	}

}
