package com.utn.controllers;

import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.services.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forms")
public class FormController {

    /*
        Form FormularioMascotaPerdida Perdida
    */

    @Autowired
    IFormService formService;

    @GetMapping("/mascotaPerdida")
    public Iterable<FormularioMascotaPerdida> GetFormsMascotaPerdida() {
        return formService.GetFormsMascotaPerdida();
    }

    @GetMapping("/mascotaPerdida/{id}")
    public FormularioMascotaPerdida GetFormMascotaPerdidaById(@PathVariable Integer id) {
        return formService.GetFormMascotaPerdidaById(id);
    }

    @PostMapping("/mascotaPerdida")
    public FormularioMascotaPerdida CreateFormMascotaPerdida(@RequestBody FormularioMascotaPerdida form) {
        return formService.CreateFormMascotaPerdida(form);
    }

    @PutMapping("/mascotaPerdida/{id}")
    public FormularioMascotaPerdida UpdateFormMascotaPerdida(@RequestBody FormularioMascotaPerdida form, @PathVariable Integer id) {
        return formService.UpdateFormMascotaPerdida(form, id);
    }

    @DeleteMapping("/mascotaPerdida/{id}")
    public void DeleteFormMascotaPerdida(@PathVariable Integer id) {
        formService.DeleteFormMascotaPerdida(id);
    }

    /*
        Form FormularioMascotaPerdida Encontrada
    */

    /*
        Form Intencion Adopcion
    */

    /*
        Form Dar Adopcion
    */
}
