package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.utn.models.mascotas.Caracteristica;
import org.springframework.stereotype.Repository;

@Repository
public class CaracteristicaRepo implements ICaracteristicaRepo{

	private EntityManagerFactory emf;
	private EntityManager manager;

	public CaracteristicaRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}
    
	@SuppressWarnings("unchecked")
    @Override
    public Iterable<Caracteristica> GetCaracteristica() {
        Iterable<Caracteristica> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Caracteristica").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Caracteristica GetCaracteristicaById(Integer id) {
        Caracteristica aux;

        this.manager.getTransaction().begin();
        aux = (Caracteristica) this.manager.createQuery("FROM Caracteristica u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Caracteristica CreateCaracteristica(Caracteristica c) {

        this.manager.getTransaction().begin();
        this.manager.persist(c);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return c;
    }

    @Override
    public Caracteristica UpdateCaracteristica(Caracteristica c, Integer id) {
        Caracteristica caractToUpdate = this.GetCaracteristicaById(id);

        this.manager.getTransaction().begin();
        caractToUpdate.setDescripcion(c.getDescripcion());
        caractToUpdate.setOpciones(c.getOpciones());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return caractToUpdate;
    }

    @Override
    public void DeleteCaracteristica(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Caracteristica WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }

    @Override
    public void DeleteCaracteristicaFiltrable(Integer id){
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from CaracteristicaFiltrable WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.flush();
        this.manager.getTransaction().commit();
    }

}
