package com.utn.repositories.RepositroriesPublication;

import com.utn.models.MascotaPerdida.FormLostPet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Repository
public class FormRepositorieLostPet implements IFormRepositorieLostPet {
    private EntityManagerFactory emf;
    private EntityManager manager;

    public FormRepositorieLostPet() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<FormLostPet> GetForms() {
        Iterable<FormLostPet> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM FormularioMascotaPerdida").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }


    @Override
    public FormLostPet GetFormsById(Integer id) {
        FormLostPet aux;

        this.manager.getTransaction().begin();
        aux = (FormLostPet) this.manager.createQuery("FROM FormularioMascotaPerdida fa WHERE fa.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormLostPet CreateForms(FormLostPet formularioMascotaPerdida) {

        this.manager.getTransaction().begin();
        this.manager.persist(formularioMascotaPerdida);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return formularioMascotaPerdida;
    }


    @Override
    public void DeleteForms(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from FormLostPet WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }
}
