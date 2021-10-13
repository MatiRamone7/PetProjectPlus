package com.utn.controllers;

import com.utn.models.mascotas.Mascota;
import com.utn.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
    public void CreatePet(@RequestParam Map<String, String> body, HttpServletResponse response) throws IOException {
    Mascota mascota = new Mascota();
        mascota.setApodo(body.get("apodo"));
        mascota.setNombre(body.get("nombre"));
        mascota.setEspecie(Mascota.Especie.valueOf(body.get("especie")));
        mascota.setDescripcionFisica(body.get("descripcionFisica"));
        mascota.setSexo(Mascota.Sexo.valueOf(body.get("sexo")));


        petService.CreatePet(mascota);

        response.sendRedirect("/Perfil");
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
