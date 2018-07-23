package com.ahealth.api.rest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

@Document(collection = "resources")
public class Resource {
	
	@Id
	private String resourceId;
	private String name;
	private String description;
	private String path;
	private String operationType;
	
	public Resource() {
		super();
	}
	
	public Resource(String name, String description, String path, String operationType) {
		super();
		this.name = name;
		this.description = description;
		this.path = path;
		this.operationType = operationType;
	}
	
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String id) {
		this.resourceId = id;
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
