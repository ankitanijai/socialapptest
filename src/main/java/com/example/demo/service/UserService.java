package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
	User doLogin(User user);

	User registerUser(User user);

	User updateUser(User user);

}
