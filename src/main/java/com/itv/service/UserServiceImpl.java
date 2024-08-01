package com.itv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itv.models.User;
import com.itv.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public String register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "User registered";
	}

}
