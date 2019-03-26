package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User doLogin(User user) {
		User users=userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
		return users;
	}

	@Override
	public User registerUser(User user) {
		User registerUser=userRepository.save(user);
		return registerUser;
	}

	@Override
	public User updateUser(User user) {
		User updateUserDetails=userRepository.save(user);
		return updateUserDetails;
	}

}
