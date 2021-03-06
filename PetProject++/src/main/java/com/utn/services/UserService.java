package com.utn.services;

import com.utn.models.users.Usuario;
import com.utn.repositories.UserRepo;
import com.utn.utils.HashUtils;
import com.utn.utils.IValidationSesion;
import com.utn.utils.ValidationSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.repositories.IUserRepo;

/**
 * Servicios de users.
 *
 * @author Grupo 14
 * @see com.utn.models.users.Usuario
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
	public Iterable<Usuario> GetUsers() {
		return userRepo.GetUsers();
	}

	/**
	 * Busca un user por Id.
	 *
	 * @param id id de user a buscar
	 * @return user existente
	 */
	@Override
	public Usuario GetUserById(Integer id) {
		return userRepo.GetUserById(id);
	}

	/**
	 * Crea un nuevo user.
	 *
	 * @param user user a crear
	 * @return nuevo user
	 */
	private IValidationSesion validationSesion = new ValidationSesion();

	public Usuario Create(Usuario user)
	{
		String name = user.getNombre();
		String password = user.getSesion().getPassword();
		String hpass;

		if (validationSesion.validarUsuarioyPass(name, password).isStatus()) {
			hpass = HashUtils.get_SHA_512_SecurePassword(password);
			user.getSesion().setPassword(hpass);
		}

		return userRepo.CreateUser(user);
	}

	/**
	 * Actualiza user existente.
	 *
	 * @param user user a actualizar
	 * @return user actualizado
	 */
	public Usuario Update(Usuario user, Integer id) {
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
