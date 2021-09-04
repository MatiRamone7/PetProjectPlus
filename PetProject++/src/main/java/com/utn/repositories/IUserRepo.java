package com.utn.repositories;

import com.utn.models.users.Usuario;

public interface IUserRepo {
	public Iterable<Usuario> GetUsers();

	public Usuario GetUserById(Integer id);

	public Usuario CreateUser(Usuario user);

	public Usuario UpdateUser(Usuario user, Integer id);

	public void DeleteUser(Integer id);
}
