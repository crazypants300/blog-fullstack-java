package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.models.BlogPost;
import com.blog.models.User;
import com.blog.repos.BlogPostRepo;
import com.blog.repos.UserRepo;

@RestController
@RequestMapping("/api")
public class UserController {

//	user repository
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BlogPostRepo blogPostRepo;
	
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
//	{
//	    "username": "user1",
//	    "password": "pass1"
//	}
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
	
//	Create blog post
//{
//    "title": "third blog post",
//    "content": "This blog post is the best post",
//    "fk_user_id": "1"
//}
//	@PostMapping("/users/{user_id}")
//	public User createPost(@RequestBody BlogPost post, @PathVariable(value="user_id") Long id) {
//		
//	}
	

}
