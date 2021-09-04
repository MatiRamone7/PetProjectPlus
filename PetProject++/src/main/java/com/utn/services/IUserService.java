package com.utn.services;

import com.utn.models.users.Usuario;

public interface IUserService {
	public Iterable<Usuario> GetUsers();

	public Usuario GetUserById(Integer id);

	public Usuario Create (Usuario user);

	public Usuario Update (Usuario user, Integer id);

	public void Delete (Integer id);
}
