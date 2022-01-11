package com.carrental.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cardetail")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String no;
	private String name;
	private String owner;
	private String company;
	private int noofcar;
	private int issued;

	public Car() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public String getCompany() {
		return company;
	}

	public int getNoofcar() {
		return noofcar;
	}

	public int getIssued() {
		return issued;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setNoofcar(int noofcar) {
		this.noofcar = noofcar;
	}

	public void setIssued(int issued) {
		this.issued = issued;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", no=" + no + ", name=" + name + ", owner=" + owner + ", company=" + company
				+ ", noofcar=" + noofcar + ", issued=" + issued + "]";
	}

}
