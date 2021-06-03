package com.utn.repositories;

import com.utn.models.Publication;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class PublicationRepo implements IPublicationRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;

    public PublicationRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Publication> GetPublications() {
        Iterable<Publication> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Publication").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Publication GetPublicationById(Integer id) {
        Publication aux;

        this.manager.getTransaction().begin();
        aux = (Publication) this.manager.createQuery("FROM Publication u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Publication CreatePublication(Publication publication) {

        this.manager.getTransaction().begin();
        this.manager.persist(publication);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return publication;
    }

    @Override
    public Publication UpdatePublication(Publication publication, Integer id) {

        Publication publicationToUpdate = this.GetPublicationById(id);

        this.manager.getTransaction().begin();
        publicationToUpdate.setFoto(publication.getFoto());
        publicationToUpdate.setLugarEncuentro(publication.getLugarEncuentro());
        publicationToUpdate.setOng(publication.getOng());
        publicationToUpdate.setRescatist(publication.getRescatist());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return publicationToUpdate;
    }

    @Override
    public void DeletePublication(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Publication WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }
}
