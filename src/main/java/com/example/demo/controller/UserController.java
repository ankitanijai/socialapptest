package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
class UserController {
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/api/user/login",consumes="application/json")
	public ResponseEntity<User>getUser(@RequestBody User user){
		logger.debug("in user login  controller:{}",user);
		User loginUser=userService.doLogin(user);
		if(loginUser!=null) {
			if(loginUser!=null && loginUser.getPassword()!=null) {
				loginUser.setPassword("xxxx");
			}
			return new ResponseEntity<User>(loginUser, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/api/user/register",consumes="application/json")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User userregister=userService.registerUser(user);
		if(userregister!=null) {
			return new ResponseEntity<User>(userregister,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(userregister,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="/api/user/update/register",consumes="application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updateUserDetails = userService.updateUser(user);
		if(updateUserDetails!=null) {
			return new ResponseEntity<>(updateUserDetails,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
