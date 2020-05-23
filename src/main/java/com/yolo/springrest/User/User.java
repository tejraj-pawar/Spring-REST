package com.yolo.springrest.User;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of a user. ")
@Entity //jpa- table entity
public class User {
	
	@Id //jpa- primary key
	@GeneratedValue //jpa- hibernate creates sequence and starts with one
	private Integer id;
	
	@Size(min=2, message = "Name should have at least two characters")
	@ApiModelProperty(notes = "Name should have at least two characters")
	private String name;
	
	@Past(message = "Date can not be greater than todays date")
	@ApiModelProperty(notes = "Date can not be greater than todays date")
	private Date birthDate;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts; 
	
	public User()
	{
	}
	
	public User(Integer id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
