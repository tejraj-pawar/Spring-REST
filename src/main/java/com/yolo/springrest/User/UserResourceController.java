package com.yolo.springrest.User;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController {
	
	@Autowired
	UserDaoService service;
	
	//retrieve all users.
	@GetMapping(path = "/users")
	public List<User> findAll()
	{
		return service.findAll();
	}
	
	//get user by ID and send exception of user is absent
	@GetMapping(path = "users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws Exception
	{
		User user = service.findUserById(id);
		/*
		// this is using hateoas, to send link("localhost:8080/users") in the response.
		// using hateous we can send other stuff in the response or with the response.
		EntityModel<User> resource = new EntityModel<User>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).finaAll());
		resource.add(linkTo.withRel("All-Users-link")); // and return this resource
		return resource;
		*/
		if(user != null)
			return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
		else
			throw new UserNotFoundException("User with ID " + id + " is not present");
	}
	
	//add user, after validation @Valid
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<User>(service.addUser(user), HttpStatus.ACCEPTED);
	}
	
	//add user and return resource URI of added user and in response header you'll find it.
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser1(@RequestBody User user)
	{
		User savedUser = service.addUser(user);
		URI location = ServletUriComponentsBuilder
    		   .fromCurrentRequest() //this will return current URI i.e "/addUser"
    		   .path("/{id}").buildAndExpand(savedUser.getId()).toUri(); //this will replace {id} value with saved user id.
		
		return ResponseEntity.created(location).build();
		//return new ResponseEntity<User>(service.addUser(user), HttpStatus.ACCEPTED);
	}	 
	
	//delete user by id.
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) throws Exception
	{
		User deletedUser = service.deleteUserById(id);
		if(deletedUser != null)
			return new ResponseEntity<Object>(HttpStatus.OK);
		else
			throw new Exception("User with ID " + id + " is not present");
	}
	
}
