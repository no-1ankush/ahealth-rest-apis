package com.ahealth.api.rest.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

@Document(collection = "physicians")
public class Physician extends Person {
	
	private String qualification;
	private List<String> specialization;
	
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
