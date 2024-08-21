package com.sellify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellify.dto.RegisterForm;
import com.sellify.dto.ResponseInfo;
import com.sellify.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseInfo> registerUser(@RequestBody RegisterForm registerForm){
		return userService.registerUser(registerForm);
	}
	
	
	
}
