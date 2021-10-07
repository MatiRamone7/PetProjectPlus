package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.utn.models.users.Comodidades.*;
import org.springframework.stereotype.Repository;

@Repository
public class ComodidadesRepo implements IComodidadesRepo{

	private EntityManagerFactory emf;
	private EntityManager manager;

	public ComodidadesRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}
    
// RADIO DE CERCANÍA

	@SuppressWarnings("unchecked")
    @Override
    public Iterable<RadioDeCercania> GetRadioDeCercania() {
        Iterable<RadioDeCercania> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM RadioDeCercania").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public RadioDeCercania GetRadioDeCercaniaById(Integer id) {
        RadioDeCercania aux;

        this.manager.getTransaction().begin();
        aux = (RadioDeCercania) this.manager.createQuery("FROM RadioDeCercania u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public RadioDeCercania CreateRadioDeCercania(RadioDeCercania c) {

        this.manager.getTransaction().begin();
        this.manager.persist(c);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return c;
    }

    @Override
    public RadioDeCercania UpdateRadioDeCercania(RadioDeCercania c, Integer id) {
        RadioDeCercania RadioDeCercaniaToUpdate = this.GetRadioDeCercaniaById(id);

        this.manager.getTransaction().begin();
        RadioDeCercaniaToUpdate.setUsuario(c.getUsuario());
        RadioDeCercaniaToUpdate.setRadio(c.getRadio());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return RadioDeCercaniaToUpdate;
    }

    @Override
    public void DeleteRadioDeCercania(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from RadioDeCercania WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }


// TIENE PATIO
        
	@SuppressWarnings("unchecked")
    @Override
    public Iterable<TienePatio> GetTienePatio() {
        Iterable<TienePatio> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM TienePatio").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public TienePatio GetTienePatioById(Integer id) {
        TienePatio aux;

        this.manager.getTransaction().begin();
        aux = (TienePatio) this.manager.createQuery("FROM TienePatio u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public TienePatio CreateTienePatio(TienePatio c) {

        this.manager.getTransaction().begin();
        this.manager.persist(c);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return c;
    }

    @Override
    public TienePatio UpdateTienePatio(TienePatio c, Integer id) {
        TienePatio TienePatioToUpdate = this.GetTienePatioById(id);

        this.manager.getTransaction().begin();
        TienePatioToUpdate.setUsuario(c.getUsuario());
        TienePatioToUpdate.setPatio(c.isPatio());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return TienePatioToUpdate;
    }

    @Override
    public void DeleteTienePatio(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from TienePatio WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }

}
