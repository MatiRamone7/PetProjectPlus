package com.utn.repositories.RepositroriesPublication;

import com.utn.models.DarEnAdopcion.FormGiveAdoption;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class FormRepositorieGiveAdoption implements IFormRepositorieGiveAdoption {
    private EntityManagerFactory emf;
    private EntityManager manager;

    public FormRepositorieGiveAdoption() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<FormGiveAdoption> GetForms() {
        Iterable<FormGiveAdoption> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM FormularioDarEnAdopcion").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }


    @Override
    public FormGiveAdoption GetFormsById(Integer id) {
        FormGiveAdoption aux;

        this.manager.getTransaction().begin();
        aux = (FormGiveAdoption) this.manager.createQuery("FROM FormularioDarEnAdopcion fa WHERE fa.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormGiveAdoption CreateForms(FormGiveAdoption formularioDarEnAdopcion) {

        this.manager.getTransaction().begin();
        this.manager.persist(formularioDarEnAdopcion);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return formularioDarEnAdopcion;
    }


    @Override
    public void DeleteForms(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from FormGiveAdoption WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }
}
