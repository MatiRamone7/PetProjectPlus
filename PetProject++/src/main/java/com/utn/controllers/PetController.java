package com.utn.controllers;

import com.utn.models.Pet;
import com.utn.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    IPetService petService;

    @PostMapping
    public Pet CreatePet(@RequestBody Pet pet) {
        return petService.CreatePet(pet);
    }

    @GetMapping("/{id}")
    public Pet GetPetById(@PathVariable Integer id) {
        return petService.GetPetById(id);
    }
}
