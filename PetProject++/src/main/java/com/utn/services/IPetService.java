package com.utn.services;


import com.utn.models.Pet;
public interface IPetService {
    public Iterable<Pet> GetPets();

    public Pet GetPetById(Integer id);

    public Pet CreatePet(Pet pet);

    public Pet UpdatePet(Pet pet, Integer id);

    public void DeletePet(Integer id);
}
