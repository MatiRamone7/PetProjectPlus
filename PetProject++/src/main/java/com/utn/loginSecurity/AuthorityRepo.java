package com.utn.loginSecurity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.utn.models.users.Authority;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityRepo implements IAuthorityRepo{
    private EntityManagerFactory emf;
    private EntityManager manager;

    public AuthorityRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }   

	public Authority GetAuthorityById(Integer id) {
		Authority aux;

		this.manager.getTransaction().begin();
		aux = (Authority) this.manager.createQuery("FROM authority u WHERE u.id = " + id.toString()).getSingleResult();
		this.manager.getTransaction().commit();

		return aux;
	}
}
