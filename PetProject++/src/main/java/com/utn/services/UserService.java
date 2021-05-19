package com.utn.services;

import com.utn.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.models.User;
import com.utn.repositories.IUserRepo;

/**
 * Servicios de cars.
 *
 * @author Grupo 14
 * @see User
 * @see UserRepo
 */
@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepo userRepo;

	/**
	 * Retorna la lista de users.
	 *
	 * @return lista de users
	 */
	@Override
	public Iterable<User> GetUsers() {		
		return userRepo.GetUsers();
	}

	/**
	 * Busca un user por Id.
	 *
	 * @param id id de user a buscar
	 * @return user existente
	 */
	@Override
	public User GetUserById(Integer id) {
		return userRepo.GetUserById(id);
	}

	/**
	 * Crea un nuevo user.
	 *
	 * @param user user a crear
	 * @return nuevo user
	 */
	public User Create(User user) {
		return userRepo.CreateUser(user);
	}

	/**
	 * Actualiza user existente.
	 *
	 * @param user user a actualizar
	 * @return user actualizado
	 */
	public User Update(User user, Integer id) {
		return userRepo.UpdateUser(user, id);
	}

	/**
	 * Borra user existente.
	 *
	 * @param id id de user a eliminar
	 */
	public void Delete(Integer id) {
		userRepo.DeleteUser(id);
	}
}
