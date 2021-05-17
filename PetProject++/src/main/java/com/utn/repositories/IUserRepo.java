package com.utn.repositories;

import com.utn.models.User;

public interface IUserRepo {
	public Iterable<User> GetUsers();

	public User GetUserById(Integer id);
}
