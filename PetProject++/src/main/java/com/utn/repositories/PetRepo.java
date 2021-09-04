package com.utn.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class PetRepo implements IPetRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;

    public PetRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Mascota> GetPets() {
        Iterable<Mascota> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Pet").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Mascota GetPetById(Integer id) {
        Mascota aux;

        this.manager.getTransaction().begin();
        aux = (Mascota) this.manager.createQuery("FROM Pet u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public Mascota CreatePet(Mascota pet) {

        this.manager.getTransaction().begin();
        this.manager.persist(pet);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return pet;
    }

    @Override
    public Mascota UpdatePet(Mascota pet, Integer id) {

        Mascota petToUpdate = this.GetPetById(id);

        this.manager.getTransaction().begin();
        petToUpdate.setNombre(pet.getNombre());
        petToUpdate.setApodo(pet.getApodo());
        petToUpdate.setSexo(pet.getSexo());
        petToUpdate.setEspecie(pet.getEspecie());
        petToUpdate.setFechaDeNacimiento(pet.getFechaDeNacimiento());
        petToUpdate.setFoto(pet.getFotos());
        petToUpdate.setQr(pet.getQr());
        petToUpdate.setUsuarioId(pet.getUsuarioId());
        petToUpdate.setCaracteristicSet(pet.getCaracteristicSet());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return petToUpdate;
    }

    @Override
    public void DeletePet(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Pet WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }
}
