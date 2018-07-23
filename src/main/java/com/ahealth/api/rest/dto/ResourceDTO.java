package com.ahealth.api.rest.dto;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

public class ResourceDTO extends ResourceSupport {

	private String resourceId;
	private String name;
	private String description;
	private String path;
	private String operationType;
	
	public ResourceDTO() {
		super();
	}

	public ResourceDTO(String resourceId, String name, String description, String path,	String operationType) {
		super();
		this.resourceId = resourceId;
		this.name = name;
		this.description = description;
		this.path = path;
		this.operationType = operationType;
	}
	
	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
}
