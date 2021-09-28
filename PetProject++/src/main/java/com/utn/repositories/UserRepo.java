package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.utn.models.users.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements IUserRepo {

	private EntityManagerFactory emf;
	private EntityManager manager;

	public UserRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Usuario> GetUsers() {
		Iterable<Usuario> aux;

		this.manager.getTransaction().begin();
		aux = this.manager.createQuery("FROM Usuario").getResultList();
		this.manager.getTransaction().commit();

		return aux;
	}

	@Override
	public Usuario GetUserById(Integer id) {
		Usuario aux;

		this.manager.getTransaction().begin();
		aux = (Usuario) this.manager.createQuery("FROM Usuario u WHERE u.id = " + id.toString()).getSingleResult();
		this.manager.getTransaction().commit();

		return aux;
	}

	@Override
	public Usuario CreateUser(Usuario user) {

		this.manager.getTransaction().begin();
		this.manager.persist(user);
		this.manager.flush();
		this.manager.getTransaction().commit();

		return user;
	}

	@Override
	public Usuario UpdateUser(Usuario user, Integer id) {
		Usuario userToUpdate = this.GetUserById(id);

		this.manager.getTransaction().begin();
		// User
		userToUpdate.setComodidades(user.getComodidades());
		userToUpdate.setLogRol(user.getLogRol());
		userToUpdate.setMascotas(user.getMascotas());
		userToUpdate.setOrganizacion(user.getOrganizacion());

		// Persona
		userToUpdate.setApellido(user.getApellido());
		userToUpdate.setContacto(user.getContacto());
		userToUpdate.setFechaNacimiento(user.getFechaNacimiento());
		userToUpdate.setNombre(user.getNombre());
		userToUpdate.setNroDocumento(user.getNroDocumento());
		userToUpdate.setTipoDocumento(user.getTipoDocumento());
		userToUpdate.setSesion(user.getSesion());
		userToUpdate.setDireccion(user.getDireccion());
		this.manager.flush();
		this.manager.getTransaction().commit();

		return userToUpdate;
	}

	@Override
	public void DeleteUser(Integer id) {

		this.manager.getTransaction().begin();
		Query query = this.manager.createQuery("delete from Usuario WHERE id = " + id.toString());
		query.executeUpdate();
		this.manager.getTransaction().commit();

	}
}
