package com.bipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipro.model.Response;
import com.bipro.model.UserModel;
import com.bipro.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepo;
 
	@PostMapping("/saveUser")
	public Response saveUser(@RequestBody UserModel user) {
		userRepo.save(user);
		Response resp=new Response();
		resp.setResponseValue("User saved successfully");
		return resp;
	}
	
	@PostMapping("/validateLogin")
	public UserModel validateLogin(@RequestBody UserModel user) {
		System.out.println(this);
		return userRepo.validateLogin(user.getMailid(),user.getPassword());
	}
	
}
