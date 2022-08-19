package com.blog.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id; // primary id
	
	private String username;
	private String password;
//	Creates a one to many relationship for blogposts
	@OneToMany(cascade = CascadeType.ALL)
//	join the columns that will be referenced
//	names the foreign key "fk_user_id" and references the column "user_id" in User (current model)
	@JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
	private List<BlogPost> blogPosts;
	
//	Getters and Listters
	public Long getId() {
		return id;
	}
	public void ListId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void ListUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void ListPassword(String password) {
		this.password = password;
	}
	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}
	public void setBlogPosts(List<BlogPost> blogPosts) {
		this.blogPosts = blogPosts;
	}
	
}
