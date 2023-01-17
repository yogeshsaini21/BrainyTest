package com.exam.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		user.setProfile("default.png");
		
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		 return this.userService.createUser(user,roles );
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<String>("Id number "+userId+" is successfully deleted", HttpStatus.OK);
	}
	
	
	//update user m
	
	
	
}
