package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.utn.models.forms.*;
import org.springframework.stereotype.Repository;

@Repository
public class GeoRepo implements IGeoRepo{
    
	private EntityManagerFactory emf;
	private EntityManager manager;

    public GeoRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}

    @Override
    public Iterable<Ciudad> GetCiudades(){
        Iterable<Ciudad> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Ciudad").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Ciudad GetCiudadById(Integer id) {
        Ciudad aux;

        this.manager.getTransaction().begin();
        aux = (Ciudad) this.manager.createQuery("FROM Ciudad u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Ciudad CreateCiudad(Ciudad Ciudad) {

        this.manager.getTransaction().begin();
        this.manager.persist(Ciudad);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return Ciudad;
    }

    @Override
    public Ciudad UpdateCiudad(Ciudad Ciudad, Integer id) {
        Ciudad CiudadToUpdate = this.GetCiudadById(id);

        this.manager.getTransaction().begin();
        CiudadToUpdate.setNombre(Ciudad.getNombre());
        CiudadToUpdate.setProvincia(Ciudad.getProvincia());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return CiudadToUpdate;
    }

    @Override
    public void DeleteCiudad(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Ciudad WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }


/** PROVINCIAS */
    @Override
    public Iterable<Provincia> GetProvincias(){
        Iterable<Provincia> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Provincia").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Provincia GetProvinciaById(Integer id) {
        Provincia aux;

        this.manager.getTransaction().begin();
        aux = (Provincia) this.manager.createQuery("FROM Provincia u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Provincia CreateProvincia(Provincia Provincia) {

        this.manager.getTransaction().begin();
        this.manager.persist(Provincia);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return Provincia;
    }

    @Override
    public Provincia UpdateProvincia(Provincia Provincia, Integer id) {
        Provincia ProvinciaToUpdate = this.GetProvinciaById(id);

        this.manager.getTransaction().begin();
        ProvinciaToUpdate.setNombre(Provincia.getNombre());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return ProvinciaToUpdate;
    }

    @Override
    public void DeleteProvincia(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Provincia WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }
}
