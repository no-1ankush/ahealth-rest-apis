package com.ahealth.api.rest.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

public class PatientDTO extends PersonDTO {

	@NotBlank(message = "registration date is required.")
	private String registrationDate;
	
	public PatientDTO() {
		super();
	}

	public PatientDTO(String id, NameDTO name, String dateOfBirth, GenderEnum gender, AddressDTO address, String registrationDate) {
		super(id, name, dateOfBirth, gender, address);
		this.registrationDate = registrationDate;
	}
	
	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
}
