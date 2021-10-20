package com.utn.controllers;

import com.utn.models.forms.Ciudad;
import com.utn.models.forms.Direccion;
import com.utn.models.forms.Provincia;
import com.utn.models.mascotas.Caracteristica;
import com.utn.models.users.ContactoUnico;
import com.utn.models.users.Sesion;
import com.utn.models.users.TipoDocumento;
import com.utn.models.users.Usuario;
import com.utn.services.ICaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    /*
        Caracteristica
    */

    @Autowired
    ICaracteristicaService caracteristicaService;

    @PostMapping
    public void Create(@RequestParam Map<String, String> body, HttpServletResponse response) throws IOException {
        Caracteristica caracteristica = new Caracteristica();

        caracteristica.setDescripcion(body.get("descripcion"));

        caracteristicaService.CreateCaracteristica(caracteristica);

        response.sendRedirect("/Admin-Perfiles-ONG");
    }

    @PostMapping("/{caracteristicaId}")
    public void CreateOpciones(@RequestParam Map<String, String> body, @PathVariable Integer caracteristicaId, HttpServletResponse response) throws IOException {
        Caracteristica caracteristica = caracteristicaService.GetCaracteristicaById(caracteristicaId);


        caracteristicaService.UpdateCaracteristica(caracteristica, caracteristicaId);


        response.sendRedirect("/Admin-Perfiles-ONG");
    }
}