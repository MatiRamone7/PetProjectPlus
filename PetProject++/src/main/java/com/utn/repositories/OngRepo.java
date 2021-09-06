package com.utn.repositories;


import com.utn.models.ongs.Organizacion;
import com.utn.models.users.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class OngRepo implements IOngRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;

    public OngRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @Override
    public Organizacion GetOngById(Integer id) {
        Organizacion aux;

        this.manager.getTransaction().begin();
        aux = (Organizacion) this.manager.createQuery("FROM Organizacion u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Organizacion CreateOng(Organizacion ong) {

        this.manager.getTransaction().begin();
        this.manager.persist(ong);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return ong;
    }

    @Override
    public Organizacion UpdateOng(Organizacion ong, Integer id) {

        Organizacion ongToUpdate = this.GetOngById(id);

        /* TODO poner los parametros correctos */

		/*
		this.manager.getTransaction().begin();
		userToUpdate.setNombre(user.getNombre());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setApellido(user.getApellido());
		userToUpdate.setFechaNacimiento(user.getFechaNacimiento());
		userToUpdate.setTipoDocumento(user.getTipoDocumento());
		userToUpdate.setNumeroDocumento(user.getNumeroDocumento());
		userToUpdate.setOng(user.getOng());
		userToUpdate.setRol(user.getRol());
		*/
        this.manager.flush();
        this.manager.getTransaction().commit();

        return ongToUpdate;
    }
}
