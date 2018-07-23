package com.ahealth.api.rest.entity;

import org.springframework.data.annotation.Id;

public class Person {

	@Id
	private String uniqueId;
	private Name name;
	private String dateOfBirth;
	private String gender;
	private Address address;
	
	public Person() {
		super();
	}

	public Person(Name name, String dateOfBirth, String gender, Address address) {
		super();
		
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}
	
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
