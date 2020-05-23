package com.yolo.springrest.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"field2", "password"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String field1;
	
	//@JsonIgnore //it wont send this field while returning bean for everyone.
	private String field2;
	
	//@JsonIgnore 
	private String password;
	
	public SomeBean(String field1, String field2, String password) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.password = password;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
