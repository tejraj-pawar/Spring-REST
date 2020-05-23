package com.yolo.springrest.versioning;

public class Name {
	
	private String fistName;
	private String lastName;
	
	public Name(String fistName, String lastName) {
		super();
		this.fistName = fistName;
		this.lastName = lastName;
	}
	
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
