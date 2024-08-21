package com.sellify.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sellify.dto.RegisterForm;
import com.sellify.dto.ResponseInfo;
import com.sellify.model.User;
import com.sellify.repository.UserRepository;
import com.sellify.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<ResponseInfo> registerUser(RegisterForm registerForm) {
		try {
			User userExists = userRepository.findFirstByEmail(registerForm.getEmail());
			if(userExists != null) {
				ResponseInfo response = new ResponseInfo("failed", "already exists", null);
				return ResponseEntity. body(response);
			}
			User user = new User();
			user.setFirstName(registerForm.getFirstName());
			user.setLastName(registerForm.getLastName());
			user.setEmail(registerForm.getEmail());
			user.setPassword(registerForm.getPassword());
			user.setCreatedOn(LocalDateTime.now());
			user.setModifiedOn(LocalDateTime.now());
			
			userRepository.save(user);
			
			ResponseInfo response = new ResponseInfo("success", "registeration successful", null);
			
			return ResponseEntity.ok().body(response);
		}
		catch(Exception e){
			ResponseInfo response = new ResponseInfo("failed", "server error", null);
			return ResponseEntity.internalServerError().body(response);
		}	
	}

}
