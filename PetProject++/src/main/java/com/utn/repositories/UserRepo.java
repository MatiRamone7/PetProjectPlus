package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.utn.models.User;

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
	public Iterable<User> GetUsers() {
		Iterable<User> aux;

		this.manager.getTransaction().begin();
		aux = this.manager.createQuery("FROM User").getResultList();
		this.manager.getTransaction().commit();

		return aux;
	}

	@Override
	public User GetUserById(Integer id) {
		User aux;

		this.manager.getTransaction().begin();
		aux = (User) this.manager.createQuery("FROM User u WHERE u.id = " + id.toString()).getSingleResult();
		this.manager.getTransaction().commit();

		return aux;
	}

	@Override
	public User CreateUser(User user) {

		this.manager.getTransaction().begin();
		this.manager.persist(user);
		this.manager.flush();
		this.manager.getTransaction().commit();

		return user;
	}

	@Override
	public User UpdateUser(User user, Integer id) {

		User userToUpdate = this.GetUserById(id);

		this.manager.getTransaction().begin();
		userToUpdate.setNombre(user.getNombre());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setApellido(user.getApellido());
		userToUpdate.setFechaNacimiento(user.getFechaNacimiento());
		userToUpdate.setTipoDocumento(user.getTipoDocumento());
		userToUpdate.setNumeroDocumento(user.getNumeroDocumento());
		userToUpdate.setOng(user.getOng());
		this.manager.flush();
		this.manager.getTransaction().commit();

		return userToUpdate;
	}

	@Override
	public void DeleteUser(Integer id) {

		this.manager.getTransaction().begin();
		Query query = this.manager.createQuery("delete from User WHERE id = " + id.toString());
		query.executeUpdate();
		this.manager.getTransaction().commit();

	}
}
