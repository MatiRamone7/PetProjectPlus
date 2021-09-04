package com.utn.controllers;

import com.utn.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    IPetService petService;

    @GetMapping
    public Iterable<Mascota> GetPets() {
        return petService.GetPets();
    }

    @GetMapping("/{id}")
    public Mascota GetPetById(@PathVariable Integer id) {
        return petService.GetPetById(id);
    }

    @PostMapping
    public Mascota CreatePet(@RequestBody Mascota pet) {
        return petService.CreatePet(pet);
    }

    @PutMapping("/{id}")
    public Mascota UpdatePet(@RequestBody Mascota pet, @PathVariable Integer id) {
        return petService.UpdatePet(pet, id);
    }

    @DeleteMapping("/{id}")
    public void DeletePet(@PathVariable Integer id) {
        petService.DeletePet(id);
    }
}
