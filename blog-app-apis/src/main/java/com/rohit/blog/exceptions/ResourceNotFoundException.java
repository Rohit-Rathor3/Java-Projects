package com.rohit.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long fieldValue;
	
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}

	public ResourceNotFoundException(String resourceName , String fieldName , Integer fieldValue) {
		
		super(String.format("%s not found with %s :%s ",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
		this.resourceName = resourceName;
	}
	
}
