package com.project.services;

import java.util.List;

import com.project.model.User;

public interface UserServices {

	public List<User> getUsers();

	public User getUser(Integer id);

	public String createUser(User user);

	public String updateUser(Integer id, User user);

	public String deletetUser(Integer id);

}
