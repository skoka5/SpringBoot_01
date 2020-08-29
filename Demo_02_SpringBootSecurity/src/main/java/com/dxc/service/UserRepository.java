package com.dxc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}
