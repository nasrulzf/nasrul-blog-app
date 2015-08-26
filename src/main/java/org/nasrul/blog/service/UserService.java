package org.nasrul.blog.service;

import org.nasrul.blog.entity.User;
import org.nasrul.blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User findByUsername(String username){
		return userRepo.findByUsername(username);
	}
	
}
