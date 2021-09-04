package com.utn.services;


public interface IPetService {
    public Iterable<Mascota> GetPets();

    public Mascota GetPetById(Integer id);

    public Mascota CreatePet(Mascota pet);

    public Mascota UpdatePet(Mascota pet, Integer id);

    public void DeletePet(Integer id);
}
