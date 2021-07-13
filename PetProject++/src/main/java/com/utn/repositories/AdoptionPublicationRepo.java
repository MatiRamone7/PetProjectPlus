package com.utn.repositories;

import com.utn.models.AdoptionPublication;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class AdoptionPublicationRepo implements IAdoptionPublicationRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;

    public AdoptionPublicationRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<AdoptionPublication> GetAdoptionPublication() {
        Iterable<AdoptionPublication> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM PublicacionDeAdopcion").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public AdoptionPublication GetAdoptionPublicationById(Integer id) {
        AdoptionPublication aux;

        this.manager.getTransaction().begin();
        aux = (AdoptionPublication) this.manager.createQuery("FROM PublicacionDeAdopcion u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public AdoptionPublication CreateAdoptionPublication(AdoptionPublication adoptionPublication) {

        this.manager.getTransaction().begin();
        this.manager.persist(adoptionPublication);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return adoptionPublication;
    }

    @Override
    public void DeleteAdoptionPublication(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from PublicacionDeAdopcion WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }

}
