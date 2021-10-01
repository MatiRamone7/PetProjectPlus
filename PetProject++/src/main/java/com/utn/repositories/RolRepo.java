package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.utn.models.roles.*;
import org.springframework.stereotype.Repository;

@Repository
public class RolRepo implements IRolRepo{

	private EntityManagerFactory emf;
	private EntityManager manager;

	public RolRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}
    
	@SuppressWarnings("unchecked")
    @Override
    public Iterable<Rol> GetRol() {
        Iterable<Rol> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Rol").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Rol GetRolById(Integer id) {
        Rol aux;

        this.manager.getTransaction().begin();
        aux = (Rol) this.manager.createQuery("FROM Rol u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Rol CreateRol(Rol rol) {

        this.manager.getTransaction().begin();
        this.manager.persist(rol);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return rol;
    }

    @Override
    public Rol UpdateRol(Rol rol, Integer id) {
        Rol rolToUpdate = this.GetRolById(id);

        this.manager.getTransaction().begin();
        rolToUpdate.setDescripcion(rol.getDescripcion());
        rolToUpdate.setPermisos(rol.getPermisos());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return rolToUpdate;
    }

    @Override
    public void DeleteRol(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Rol WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }

}