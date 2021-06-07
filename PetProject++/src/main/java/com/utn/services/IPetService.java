package com.utn.services;


import com.utn.models.Pet;

public interface IPetService {
    public Pet CreatePet (Pet pet);

    public Pet GetPetById(Integer id);
}
