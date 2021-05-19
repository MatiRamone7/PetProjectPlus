package com.utn.repositories;

import com.utn.models.User;

public interface IUserRepo {
	public Iterable<User> GetUsers();

	public User GetUserById(Integer id);

	public User CreateUser(User user);

	public User UpdateUser(User user, Integer id);

	public void DeleteUser(Integer id);
}
