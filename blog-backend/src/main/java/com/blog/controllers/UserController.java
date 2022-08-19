package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.models.User;
import com.blog.repos.UserRepo;

@RestController
@RequestMapping("/api")
public class UserController {

//	user repository
	@Autowired
	public UserRepo userRepo;
	
//	Get all users
	@GetMapping("/users")
	public List<User> getUsers() {
		System.out.println("Get all users request made.");
		List<User> users = userRepo.findAll();
		return users;
	}
//	Get a single user
	@GetMapping("/users/{id}")
	public User getUsers(@PathVariable(value="id") Long id) {
		System.out.println("Get single user request made.");
		return userRepo.findById(id).orElse(null);
	}
//	Add a new user
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		System.out.println("Add user request made.");
		return userRepo.save(user);
	}
//	Delete a user
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable(value="id") Long id) {
		System.out.println("Delete request made.");
		userRepo.deleteById(id);
	}
}
