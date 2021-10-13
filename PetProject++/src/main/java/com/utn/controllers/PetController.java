package com.utn.controllers;

import com.utn.models.forms.Foto;
import com.utn.models.mascotas.Caracteristica;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.mascotas.Mascota;
import com.utn.services.ICaracteristicaService;
import com.utn.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    IPetService petService;

    @Autowired
    ICaracteristicaService caracteristicaService;

    @GetMapping
    public Iterable<Mascota> GetPets() {
        return petService.GetPets();
    }

    @GetMapping("/{id}")
    public Mascota GetPetById(@PathVariable Integer id) {
        return petService.GetPetById(id);
    }

    @PostMapping
    public void CreatePet(@RequestParam Map<String, String> body, @RequestParam("imagen") MultipartFile img, HttpServletResponse response) throws IOException {
    Mascota mascota = new Mascota();
        mascota.setApodo(body.get("apodo"));
        mascota.setNombre(body.get("nombre"));
        mascota.setEspecie(Mascota.Especie.valueOf(body.get("especie")));
        mascota.setDescripcionFisica(body.get("descripcionFisica"));
        mascota.setSexo(Mascota.Sexo.valueOf(body.get("sexo")));
        mascota.setFechaDeNacimiento(LocalDate.parse(body.get("fechaDeNacimiento")));

        Iterable<Caracteristica> caracteristicas = caracteristicaService.GetCaracteristicas();
        Set<CaracteristicaPet> caracteristicasPets = new HashSet<>();
        for(Caracteristica caracteristica : caracteristicas){
            if(!body.get(caracteristica.getDescripcion()).isEmpty()) {
                CaracteristicaPet caracteristicaPet = new CaracteristicaPet();
                Caracteristica caract = new Caracteristica();
                caract.setId(caracteristica.getId());
                caracteristicaPet.setTipoCaracteristica(caract);
                caracteristicaPet.setValor(body.get(caracteristica.getDescripcion()));
                caracteristicasPets.add(caracteristicaPet);
            }
        }
        mascota.setCaracteristicSet(caracteristicasPets);

        List<Foto> fotos = new ArrayList<>();
        fotos.add(new Foto(img.getBytes(), img.getName()));
        mascota.setFotos(fotos);
        mascota.setDescripcionFisica(body.get("descripcionFisica"));

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
