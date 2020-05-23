package com.yolo.springrest.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository //or you can use @Component
public class UserDaoService {
	private static List<User> usersList = new ArrayList<User>();
	
	static {
		 usersList.add(new User(1, "Adam", new Date()));
		 usersList.add(new User(2, "Adam2", new Date()));
		 usersList.add(new User(3, "Adam3", new Date()));
	 }
	
	 public List<User> findAll()
	 {
		 return usersList;
	 }
	 
	 public User addUser(User user)
	 {
		usersList.add(user);
		return user;
	 }
	 
	 public User findUserById(int id)
	 {
		 for(User user : usersList)
		 {
			 if(user.getId() == id)
				 return user;
		 }
		 return null; 
	 }
	 
	 public User deleteUserById(int id)
	 {
		 Iterator<User> iterator = usersList.iterator();
		 while(iterator.hasNext())
		 {
			 User user = iterator.next();
			 if(user.getId() == id)
			 {
				 iterator.remove();
				 return user;
			 }
		 }
		 return null;
	 }
	 
	 
}
