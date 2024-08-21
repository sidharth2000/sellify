package com.sellify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellify.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findFirstByEmail(String email);
	
}
