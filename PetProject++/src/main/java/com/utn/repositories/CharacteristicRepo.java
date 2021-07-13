package com.utn.repositories;

import com.utn.models.Characteristic;
import com.utn.models.Publication;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class CharacteristicRepo implements  ICharacteristicRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;

    public CharacteristicRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Characteristic> GetAll() {
        Iterable<Characteristic> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Characteristic").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Characteristic GetById(Integer id) {
        Characteristic aux;

        this.manager.getTransaction().begin();
        aux = (Characteristic) this.manager.createQuery("FROM Characteristic u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Characteristic Create(Characteristic characteristic) {
        this.manager.getTransaction().begin();
        this.manager.persist(characteristic);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return characteristic;
    }

    @Override
    public Characteristic Update(Characteristic characteristic, Integer id) {
        Characteristic characteristicToUpdate = this.GetById(id);

        this.manager.getTransaction().begin();
        this.manager.merge(characteristic);
        this.manager.getTransaction().commit();

        return characteristic;
    }

    @Override
    public void Delete(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Characteristic WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }
}
