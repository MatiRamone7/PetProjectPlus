package com.utn.repositories;

import com.utn.models.users.Authority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class AuthorityRepo implements IAuthorityRepo {

    private EntityManagerFactory emf;
    private EntityManager manager;

    public AuthorityRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @Override
    public Iterable<Authority> GetAuthority() {
        Iterable<Authority> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Authority").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Authority GetAuthorityById(Integer id) {
        Authority aux;

        this.manager.getTransaction().begin();
        aux = (Authority) this.manager.createQuery("FROM Authority u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }
}