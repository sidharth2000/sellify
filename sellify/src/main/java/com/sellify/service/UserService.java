package com.sellify.service;

import org.springframework.http.ResponseEntity;

import com.sellify.dto.RegisterForm;
import com.sellify.dto.ResponseInfo;


public interface UserService {
	
	public ResponseEntity<ResponseInfo> registerUser(RegisterForm registerForm);
	

}
