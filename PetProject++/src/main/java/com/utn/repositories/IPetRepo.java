package com.utn.repositories;

import com.utn.models.Pet;

public interface IPetRepo {
    public Pet CreatePet(Pet pet);

    public Pet GetPetById(Integer id);

}
