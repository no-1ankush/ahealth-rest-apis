package com.ahealth.api.rest.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

public class PersonDTO extends ResourceSupport {

	@Null(message = "id should not be passed.")
	@JsonProperty("id")
	private String uniqueId;
	
	@Valid
	private NameDTO name;
	
	@NotBlank(message = "Date of birth is required.")
	private String dateOfBirth;
	
	@NotNull(message = "Gender is required.")
	private GenderEnum gender;
	
	@Valid
	private AddressDTO address;
	
	public PersonDTO() {
		super();
	}

	public PersonDTO(String uniqueId, NameDTO name, String dateOfBirth, GenderEnum gender, AddressDTO address) {
		super();
		this.uniqueId = uniqueId;
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
	public NameDTO getName() {
		return name;
	}
	public void setName(NameDTO name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
}
