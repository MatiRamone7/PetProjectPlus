package com.utn.repositories;

import com.utn.models.Pet;

public interface IPetRepo {
    public Iterable<Pet> GetPets();

    public Pet GetPetById(Integer id);

    public Pet CreatePet(Pet pet);

    public Pet UpdatePet(Pet pet, Integer id);

    public void DeletePet(Integer id);
}
