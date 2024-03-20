package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.project.model.User;
import com.project.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices services;

	@GetMapping("/home")
		public String home() {
			return "Welcome to homepage";	
		}
	
	
	//get 
	@GetMapping("/users")
	public List<User> getUsers(){
		System.out.println("i am getUsers from UserController class");
			return this.services.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Integer id){
		System.out.println("i am getUser by ID from UserController class");	
		return this.services.getUser(id);
	}
	
	@PostMapping("/users")
	public String createUser(@RequestBody User user){
		System.out.println("i am createUser from UserController class");	
		return this.services.createUser(user);
	}
	
	@PutMapping("/users/{id}")
	public String updateUser(@PathVariable Integer id, @RequestBody User user) {
		System.out.println("i am update method from UserController class");	
		return this.services.updateUser(id, user);
	}
	
	@DeleteExchange("/users/{id}")
	public String deleteUser(@PathVariable Integer id){
		System.out.println("i am deleteUser method from UserController class");	
		return this.services.deletetUser(id);
	}
}

//i have removed below dependency from pom.xml file and commented out here to use it later when i move to mysql database
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>