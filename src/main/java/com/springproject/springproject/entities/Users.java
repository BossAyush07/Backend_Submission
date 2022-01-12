package com.springproject.springproject.entities;

import org.springframework.data.mongodb.core.mapping.Document;

//import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	
//public Users(String firstname, String lastname) {
//		super();
//		this.firstname = firstname;
//		this.lastname = lastname;
//	}
//private String firstname;
//private String lastname;
//public String getFirstname() {
//	return firstname;
//}
//public void setFirstname(String firstname) {
//	this.firstname = firstname;
//}
//public String getLastname() {
//	return lastname;
//}
//public void setLastname(String lastname) {
//	this.lastname = lastname;
//}
	

	public Users() {
		super();
		
	}
	public Users(String id, String name, String email, Address address, String phone, String website, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}
	private String id;
	private String name;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
