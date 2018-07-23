package com.ahealth.api.rest.dto;

import javax.validation.constraints.Size;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

public class NameDTO {

	private String prefix;
	@Size(min=3, message="First name should be atleast 3 characters long.")
	private String firstName;
	private String middleName;
	@Size(min=3, message="First name should be atleast 3 characters long.")
	private String lastName;
	private String suffix;
	
	public NameDTO() {
		super();
	}

	public NameDTO(String prefix, String firstName, String middleName, String lastName, String suffix) {
		super();
		this.prefix = prefix;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
