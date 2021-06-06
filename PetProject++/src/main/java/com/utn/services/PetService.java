package com.utn.services;

import com.utn.models.Pet;
import com.utn.repositories.IPetRepo;
import com.utn.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de pets.
 *
 * @author Grupo 14
 * @see Pet
 * @see PetRepo
 */
@Service
public class PetService implements IPetService{
    @Autowired
    IPetRepo petRepo;

    /**
     * Crea un nuevo pet.
     *
     * @param pet pet a crear
     * @return nuevo pet
     */
    public Pet CreatePet(Pet pet) {
        return petRepo.CreatePet(pet);
    }
}
