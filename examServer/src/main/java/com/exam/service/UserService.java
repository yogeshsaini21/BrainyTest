package com.exam.service;

import java.util.Set;

import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {

	//creating user
	public User createUser(User user,Set<UserRole>  userRoles) throws Exception;
	
	public User getUser(String username);
	
	public void deleteUser(Long userId);
	
	
}
