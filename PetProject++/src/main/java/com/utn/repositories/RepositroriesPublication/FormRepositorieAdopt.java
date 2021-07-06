package com.utn.repositories.RepositroriesPublication;

import com.utn.models.IntencionAdoptar.FormAdopt;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class FormRepositorieAdopt implements IFormRepositorieAdopt {
    private EntityManagerFactory emf;
    private EntityManager manager;

    public FormRepositorieAdopt() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<FormAdopt> GetForms() {
        Iterable<FormAdopt> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM FormularioAdoptar").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }


    @Override
    public FormAdopt GetFormsById(Integer id) {
        FormAdopt aux;

        this.manager.getTransaction().begin();
        aux = (FormAdopt) this.manager.createQuery("FROM FormularioAdoptar fa WHERE fa.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormAdopt CreateForms(FormAdopt formularioAdoptar) {

        this.manager.getTransaction().begin();
        this.manager.persist(formularioAdoptar);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return formularioAdoptar;
    }


    @Override
    public void DeleteForms(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from FormularioAdoptar WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }


}
