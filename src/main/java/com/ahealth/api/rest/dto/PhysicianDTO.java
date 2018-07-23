package com.ahealth.api.rest.dto;

import java.util.List;

import javax.validation.constraints.Size;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

public class PhysicianDTO extends PersonDTO {

	@Size(min=1, message="Qualification is required.")
	private String qualification;
	private List<String> specialization;

	public PhysicianDTO() {
		super();
	}

	public PhysicianDTO(String id, NameDTO name, String dateOfBirth, GenderEnum gender, AddressDTO address, 
				String qualification, List<String> specialization) {
		super(id, name, dateOfBirth, gender, address);
		this.qualification = qualification;
		this.specialization = specialization;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<String> getSpecialization() {
		return specialization;
	}

	public void setSpecialization(List<String> specialization) {
		this.specialization = specialization;
	}
}
