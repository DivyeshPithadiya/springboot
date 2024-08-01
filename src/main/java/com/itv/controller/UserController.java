package com.itv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itv.models.User;
import com.itv.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/register")
	public String saveUser(@RequestBody User user) {
		return service.register(user);
	}
	
	@GetMapping("user")
	public String user() {
		return "user";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}
	

}
