package com.utn.controllers;

import com.utn.models.Characteristic;
import com.utn.services.ICharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characteristic")
public class CharacteristicController {
    /**
     * Controlador de publications.
     */
    @Autowired
    ICharacteristicService characteristicService;

    @GetMapping()
    public Iterable<Characteristic> GetAll() {
        return characteristicService.GetAll();
    }

    @GetMapping("/{id}")
    public Characteristic GetById(@PathVariable Integer id) {
        return characteristicService.GetById(id);
    }

    @PostMapping()
    public Characteristic Create(@RequestBody Characteristic characteristic) {
        return characteristicService.Create(characteristic);
    }

    @PutMapping("/{id}")
    public Characteristic Update(@RequestBody Characteristic characteristic, @PathVariable Integer id) {
        return characteristicService.Update(characteristic, id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id) {
        characteristicService.Delete(id);
    }
}
