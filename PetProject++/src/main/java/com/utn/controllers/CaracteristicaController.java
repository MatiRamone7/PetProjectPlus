package com.utn.controllers;


import com.utn.models.mascotas.Caracteristica;
import com.utn.models.mascotas.CaracteristicaFiltrable;
import com.utn.services.ICaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
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
        String descripcion = body.get("descripcion");
        if(!descripcion.isEmpty()) {
            caracteristica.setDescripcion(descripcion);
        }
        caracteristicaService.CreateCaracteristica(caracteristica);

        response.sendRedirect("Preguntas-Mascotas");
    }

    @PostMapping("/{caracteristicaId}")
    public void CreateOpciones(@RequestParam Map<String, String> body, @PathVariable Integer caracteristicaId, HttpServletResponse response) throws IOException {
        String descripcion = body.get("descripcion");
        if(!descripcion.isEmpty()) {
            Caracteristica caracteristica = caracteristicaService.GetCaracteristicaById(caracteristicaId);
            List<CaracteristicaFiltrable> opciones = caracteristica.getOpciones();
            CaracteristicaFiltrable opcion = new CaracteristicaFiltrable();
            opcion.setValor(descripcion);
            opcion.setCaracteristica(caracteristica);
            opciones.add(opcion);

            caracteristica.setOpciones(opciones);

            caracteristicaService.UpdateCaracteristica(caracteristica, caracteristicaId);
        }

        response.sendRedirect("/Preguntas-Mascotas/Respuestas/" + caracteristicaId);
    }

    @PostMapping("/{caracteristicaId}/{opcionId}")
    public void CreateOpciones(@RequestParam Map<String, String> body, @PathVariable Integer caracteristicaId, @PathVariable Integer opcionId, HttpServletResponse response) throws IOException {
        Caracteristica caracteristica = caracteristicaService.GetCaracteristicaById(caracteristicaId);
        List<CaracteristicaFiltrable> opciones = caracteristica.getOpciones();
        int idx = 0;
        while (idx < opciones.size())
        {
            if(opciones.get(idx).getId() == opcionId) {
                opciones.remove(idx);
            }
            else {
                ++idx;
            }
        }

        //caracteristica.setOpciones(opciones);
        //caracteristicaService.UpdateCaracteristica(caracteristica, caracteristicaId);
        caracteristicaService.DeleteCaracteristicaFiltrable(opcionId);


        response.sendRedirect("/Preguntas-Mascotas/Respuestas/" + caracteristicaId);
    }
}