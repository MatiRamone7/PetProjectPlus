package com.utn.services;

import com.utn.models.User;

public interface IUserService {
	public Iterable<User> GetUsers();

	public User GetUserById(Integer id);
}
