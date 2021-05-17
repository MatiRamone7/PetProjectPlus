package com.utn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.models.User;
import com.utn.repositories.IUserRepo;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepo userRepo;

	@Override
	public Iterable<User> GetUsers() {		
		return userRepo.GetUsers();
	}

	@Override
	public User GetUserById(Integer id) {
		return userRepo.GetUserById(id);
	}
}
