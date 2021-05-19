package com.utn.repositories;

import java.util.ArrayList;

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
	public User UpdateUser(User user) {
		return null;
	}

	@Override
	public void DeleteUser(Integer id) {

	}
}
