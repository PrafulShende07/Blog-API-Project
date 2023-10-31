package com.CodewithblogApplication.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s Not Found with this %s : %s", resourceName, fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
// %s Not Found with %s : %l
// resourceName(%s) not found with this name %s(resourceName) : userId(%l)
}
