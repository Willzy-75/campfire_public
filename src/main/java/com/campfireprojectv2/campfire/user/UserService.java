package com.campfireprojectv2.campfire.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class UserService {
	private static List<User> users = new ArrayList<User>();
	private static int userCount = 100;
	
	public List<User> findByUsername(String username) {
		Predicate<? super User> predicate = user -> 
			user.getUsername().equalsIgnoreCase(username);
		return users.stream().filter(predicate).toList();
	}
	
	public void addUser(String username, String password, String usertype, String email, boolean loggedin) {
		User user = new User(userCount++, username, password, usertype, email, loggedin);
		users.add(user);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}
	
	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		User user = users.stream().filter(predicate).findFirst().get();
		return user;
	}
	
	public void updateUser(@Valid User user) {
		deleteById(user.getId());
		users.add(user);
	}
	
}
