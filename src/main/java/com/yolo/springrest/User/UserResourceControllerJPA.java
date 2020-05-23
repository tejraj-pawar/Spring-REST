package com.yolo.springrest.User;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
public class UserResourceControllerJPA {
	
	@Autowired
	private UserDaoRepository userDaoRepository;
	
	@Autowired
	private PostDaoRepository postDaoRepository;
	
	//retrieve all users.
	@GetMapping(path = "/jpa/users")
	public List<User> findAll()
	{
		return userDaoRepository.findAll();
	}  
	
	//get user by ID and send exception of user is absent
	@GetMapping(path = "/jpa/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws Exception
	{
		// Optional handles null values, what if there is no user with given Id.
		Optional<User> user = userDaoRepository.findById(id);
		
		if(user.isPresent())
			return new ResponseEntity<User>(user.get(), HttpStatus.ACCEPTED);
		else
			throw new UserNotFoundException("User with ID " + id + " is not present");
	}
	
	//add user, after validation @Valid
	@PostMapping("/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<User>(userDaoRepository.save(user), HttpStatus.ACCEPTED);
	}
	
	//delete user by id.
	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable int id) throws Exception
	{
		userDaoRepository.deleteById(id);
	}	
		
	//add user and return resource URI of added user and in response header you'll find it.
	@PostMapping("/jpa/adduser")
	public ResponseEntity<User> addUser1(@RequestBody User user)
	{
		User savedUser = userDaoRepository.save(user);
		URI location = ServletUriComponentsBuilder
    		   .fromCurrentRequest() //this will return current URI i.e "/addUser"
    		   .path("/{id}").buildAndExpand(savedUser.getId()).toUri(); //this will replace {id} value with saved user id.
		
		return ResponseEntity.created(location).build();
		//return new ResponseEntity<User>(service.addUser(user), HttpStatus.ACCEPTED);
	}	 
	
	//retrieve all post of specific user
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> findAllPosts(@PathVariable int id)
	{
		Optional<User> user = userDaoRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User with Id " +id+ " not found!!");
		List<Post> posts = user.get().getPosts();
		return posts;
	} 
	
	//retrieve specific post of specific user
	@GetMapping(path = "/jpa/users/{id}/posts/{postId}")
	public Post findPostbyId(@PathVariable int id, @PathVariable int postId) throws Exception
	{
		Optional<User> user = userDaoRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User with Id " +id+ " not found!!");
		List<Post> posts = user.get().getPosts();
		for(Post post : posts)
		{
			if(post.getId() == postId)
				return post;
		}
		throw new Exception("for user with Id " + id + " there is no post " + postId);
	}	
	
	//add post for a user and return a resource URI of added post and in response header you'll find it.
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<User> addPostForUser(@PathVariable int id, @RequestBody Post post)
	{
		Optional<User> savedUser = userDaoRepository.findById(id);
		if(!savedUser.isPresent())
			throw new UserNotFoundException("User with Id " +id+ " not found!!");
		
		User user = savedUser.get();
		post.setUser(user );
		postDaoRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
    		   .fromCurrentRequest() //this will return current URI i.e "/addUser"
    		   .path("/{post-id}").buildAndExpand(post.getId()).toUri(); //this will replace {id} value with saved user id.
		
		return ResponseEntity.created(location).build();
	}	
	
}
