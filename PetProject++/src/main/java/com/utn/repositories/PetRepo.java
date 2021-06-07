package com.utn.repositories;

import com.utn.models.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class PetRepo implements IPetRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;

    public PetRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @Override
    public Pet CreatePet(Pet pet) {

        this.manager.getTransaction().begin();
        this.manager.persist(pet);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return pet;
    }

    @Override
    public Pet GetUserById(Integer id) {
        Pet aux;

        this.manager.getTransaction().begin();
        aux = (Pet) this.manager.createQuery("FROM Pet u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }
}
