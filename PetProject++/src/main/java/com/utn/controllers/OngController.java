package com.utn.controllers;

import com.utn.models.forms.Ciudad;
import com.utn.models.forms.Direccion;
import com.utn.models.forms.Provincia;
import com.utn.models.ongs.Organizacion;
import com.utn.models.users.ContactoUnico;
import com.utn.models.users.Sesion;
import com.utn.models.users.TipoDocumento;
import com.utn.models.users.Usuario;
import com.utn.services.IOngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    IOngService ongService;

    @GetMapping("/{id}")
    public Organizacion GetOngById(@PathVariable Integer id) {
        return ongService.GetOngById(id);
    }

    @PostMapping("/json")
    public Organizacion Create(@RequestBody Organizacion ong) throws IOException {
        return ongService.Create(ong);
    }

    @PostMapping
    public void Create(@RequestParam Map<String, String> body, HttpServletResponse response) throws IOException {
        response.sendRedirect("/Inicio");
    }

    @PutMapping("/{id}")
    public Organizacion Update(@RequestBody Organizacion ong, @PathVariable Integer id) {
        return ongService.Update(ong, id);
    }

    @GetMapping("agregarPregunta/{id}")
    public Organizacion AgregarPreguntaOng(@RequestBody String pregunta, @PathVariable Integer id) {
        return ongService.AgregarPreguntaOng(pregunta, id);
    }

    @GetMapping("quitarPregunta/{id}")
    public Organizacion QuitarPreguntaOng(@RequestBody String pregunta, @PathVariable Integer id) {
        return ongService.QuitarPreguntaOng(pregunta, id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id) {
        ongService.DeleteOng(id);
    }
}
