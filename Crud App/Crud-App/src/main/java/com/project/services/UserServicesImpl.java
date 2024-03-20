package com.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.model.User;

@Service
public class UserServicesImpl implements UserServices {

	List<User> list;
	
	public UserServicesImpl() {
		System.out.println("User services implimentation called");
		list = new ArrayList<>();
		list.add(new User(1,"harsh"));
		list.add(new User(2,"nikunj"));
	}

	
	//get all users
	@Override
	public List<User> getUsers() {
		System.out.println("i am getUsers from UserServiceImpl class");
		return list;
	}

	//get user by ID
	@Override
	public User getUser(Integer id) {
		System.out.println("i am getUser by ID from UserServiceImpl class");
		
		User user = null;
		for(User u : list) {
			if(u.getId()==id) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	//create new user
	@Override
	public String createUser(User user) {
		list.add(new User(user.getId(), user.getName()));
		return "User created Successfully";
	}

	//update user
	@Override
	public String updateUser(Integer id, User user) {
		for(User u : list) {
			if(u.getId()==id) {
				u.setId(user.getId());
				u.setName(user.getName());
			}
		}
		return "User updated Successfully";	
	}

	//delete user
	@Override
	public String deletetUser(Integer id) {
		User user = null;
		for(User u : list) {
			if(u.getId()==id) {
				user = u;
				break;
			}
		}
		list.remove(user);
		return "User deleted Successfully";
	}
	

}
