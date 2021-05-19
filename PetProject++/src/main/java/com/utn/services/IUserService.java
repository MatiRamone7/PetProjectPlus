package com.utn.services;

import com.utn.models.User;

public interface IUserService {
	public Iterable<User> GetUsers();

	public User GetUserById(Integer id);

	public User Create (User user);

	public User Update (User user, Integer id);

	public void Delete (Integer id);
}
