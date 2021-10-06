package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.utn.models.forms.Estado;

public class EstadoRepo implements IEstadoRepo{
    
	private EntityManagerFactory emf;
	private EntityManager manager;

	public EstadoRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}

	@SuppressWarnings("unchecked")
    @Override
    public Iterable<Estado> GetEstados() {
        Iterable<Estado> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Caracteristica").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Estado GetEstadoById(Integer id) {
        Estado aux;

        this.manager.getTransaction().begin();
        aux = (Estado) this.manager.createQuery("FROM Estado u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Estado CreateEstado(Estado Estado) {

        this.manager.getTransaction().begin();
        this.manager.persist(Estado);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return Estado;
    }

    @Override
    public Estado UpdateEstado(Estado Estado, Integer id) {
        Estado EstadoToUpdate = this.GetEstadoById(id);

        this.manager.getTransaction().begin();
        EstadoToUpdate.setNombre(Estado.getNombre());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return EstadoToUpdate;
    }

    @Override
    public void DeleteEstado(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Estado WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }

}
