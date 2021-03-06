package com.utn.controllers;

import com.google.zxing.WriterException;
import com.utn.models.forms.Foto;
import com.utn.models.mascotas.Caracteristica;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.mascotas.Mascota;
import com.utn.models.users.Usuario;
import com.utn.services.ICaracteristicaService;
import com.utn.services.IPetService;
import com.utn.services.IUserService;
import com.utn.utils.GeneradorQR;

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

    @Autowired
    IUserService userService;

    @GetMapping
    public Iterable<Mascota> GetPets() {
        return petService.GetPets();
    }

    @GetMapping("/{id}")
    public Mascota GetPetById(@PathVariable Integer id) {
        return petService.GetPetById(id);
    }

    @PostMapping("/{duenioId}")
    public void CreatePet(@RequestParam Map<String, String> body, @PathVariable Integer duenioId, @RequestParam("imagen") MultipartFile img, HttpServletResponse response) throws IOException {
    Mascota mascota = new Mascota();
        mascota.setApodo(body.get("apodo"));
        mascota.setNombre(body.get("nombre"));
        mascota.setEspecie(Mascota.Especie.valueOf(body.get("especie")));
        mascota.setDescripcionFisica(body.get("descripcionFisica"));
        mascota.setSexo(Mascota.Sexo.valueOf(body.get("sexo")));
        mascota.setFechaDeNacimiento(LocalDate.parse(body.get("fechaDeNacimiento")));

        Usuario duenio = userService.GetUserById(duenioId);

        mascota.setDuenio(duenio);

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

        GeneradorQR generadorQR = new GeneradorQR();
        Foto qr = new Foto();

        petService.CreatePet(mascota);
        Mascota pet = petService.GetPetById(mascota.getId());

        try {
            byte[] array = generadorQR.generar("http://localhost:8080/Mascota-Perdida/" + mascota.getId().toString(), "UTF-8", 300, 300);
            qr.setImagenByteArray(array); //TODO poner bien la url cuando est?? (y mostrar por pantalla)
            qr.setDescripcion("QR de mascota");
            pet.setQr(qr);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        petService.UpdatePet(pet,pet.getId());

        Set<Mascota> mascotasDuenio = duenio.getMascotas();
        mascotasDuenio.add(mascota);
        duenio.setMascotas(mascotasDuenio);

        userService.Update(duenio, duenioId);

        response.sendRedirect("/Perfil/" + duenioId.toString());
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
