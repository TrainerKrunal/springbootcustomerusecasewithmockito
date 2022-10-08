package com.scb.sgml.demospringbootapp.entities;

public class Customer {

	private int id;
	private String name;
	private String email;
	private long phone;
	private String accountType;
	
	
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", accountType="
				+ accountType + "]";
	}

	public Customer() {
		 
	}
	
	public Customer(int id, String name, String email, long phone, String accountType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.accountType = accountType;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}





	
	
}
