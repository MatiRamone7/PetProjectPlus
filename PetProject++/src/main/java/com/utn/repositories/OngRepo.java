package com.utn.repositories;


import com.utn.models.Ong;
import com.utn.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class OngRepo implements IOngRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;

    public OngRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @Override
    public Ong CreateOng(Ong ong) {

        this.manager.getTransaction().begin();
        this.manager.persist(ong);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return ong;
    }
}
