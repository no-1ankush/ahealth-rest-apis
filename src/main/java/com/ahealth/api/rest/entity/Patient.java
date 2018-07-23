package com.ahealth.api.rest.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

@Document(collection = "patients")
public class Patient extends Person {

	private String registrationDate;

	public Patient() {
		super();
	}

	public Patient(Name name, String dateOfBirth, String gender, Address address, String registrationDate) {
		super(name, dateOfBirth, gender, address);
		this.registrationDate = registrationDate;
	}
	
	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
}
