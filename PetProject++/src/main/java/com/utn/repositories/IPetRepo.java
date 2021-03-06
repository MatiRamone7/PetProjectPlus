package com.utn.repositories;

import com.utn.models.mascotas.Mascota;

public interface IPetRepo {
    public Iterable<Mascota> GetPets();

    public Mascota GetPetById(Integer id);

    public Mascota CreatePet(Mascota pet);

    public Mascota UpdatePet(Mascota pet, Integer id);

    public void DeletePet(Integer id);
}
