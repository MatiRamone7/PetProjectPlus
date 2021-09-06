package com.utn.controllers;

import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.users.Usuario;
import com.utn.services.IOngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    IOngService ongService;

    @PostMapping
    public Organizacion Create(@RequestBody Organizacion ong) throws IOException {
        return ongService.Create(ong);
    }

    @PutMapping("/{id}")
    public Organizacion Update(@RequestBody Organizacion ong, @PathVariable Integer id) {
        return ongService.Update(ong, id);
    }

    @PutMapping("/{id}")
    public Organizacion AgregarPregunta(@RequestBody String pregunta, @PathVariable Integer id) {
        return ongService.AgregarPregunta(pregunta, id);
    }

    @PutMapping("/{id}")
    public Organizacion QuitarPregunta(@RequestBody String pregunta, @PathVariable Integer id) {
        return ongService.QuitarPregunta(pregunta, id);
    }
}
