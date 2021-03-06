package com.utn.services;

import com.utn.models.mascotas.Mascota;
import com.utn.repositories.IPetRepo;
import com.utn.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de pets.
 *
 * @author Grupo 14
 * @see Mascota
 * @see PetRepo
 */
@Service
public class PetService implements IPetService{
    @Autowired
    IPetRepo petRepo;

    /**
     * Retorna la lista de pets.
     *
     * @return lista de pets
     */
    @Override
    public Iterable<Mascota> GetPets() {
        return petRepo.GetPets();
    }

    /**
     * Busca una pet por Id.
     *
     * @param id id de user a buscar
     * @return user existente
     */
    @Override
    public Mascota GetPetById(Integer id) {
        return petRepo.GetPetById(id);
    }

    /**
     * Crea un nuevo pet.
     *
     * @param pet pet a crear
     * @return nuevo pet
     */
    public Mascota CreatePet(Mascota pet) {
        return petRepo.CreatePet(pet);
    }

    /**
     * Actualiza pet existente.
     *
     * @param pet pet a actualizar
     * @return pet actualizado
     */
    public Mascota UpdatePet(Mascota pet, Integer id) {
        return petRepo.UpdatePet(pet, id);
    }

    /**
     * Borra pet existente.
     *
     * @param id id de pet a eliminar
     */
    public void DeletePet(Integer id) {
        petRepo.DeletePet(id);
    }

}
