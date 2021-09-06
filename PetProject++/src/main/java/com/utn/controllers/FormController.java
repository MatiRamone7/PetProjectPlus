package com.utn.controllers;

import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.forms.FormularioIntencionAdopcion;
import com.utn.models.forms.FormularioMascotaEncontrada;
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
        Form Mascota Encontrada
    */
    @GetMapping("/mascotaEncontrada")
    public Iterable<FormularioMascotaEncontrada> GetFormsMascotaEncontrada() {
        return formService.GetFormsMascotaEncontrada();
    }

    @GetMapping("/mascotaEncontrada/{id}")
    public FormularioMascotaEncontrada GetFormMascotaEncontradaById(@PathVariable Integer id) {
        return formService.GetFormMascotaEncontradaById(id);
    }

    @PostMapping("/mascotaEncontrada")
    public FormularioMascotaEncontrada CreateFormMascotaEncontrada(@RequestBody FormularioMascotaEncontrada form) {
        return formService.CreateFormMascotaEncontrada(form);
    }

    @PutMapping("/mascotaEncontrada/{id}")
    public FormularioMascotaEncontrada UpdateFormMascotaEncontrada(@RequestBody FormularioMascotaEncontrada form, @PathVariable Integer id) {
        return formService.UpdateFormMascotaEncontrada(form, id);
    }

    @DeleteMapping("/mascotaEncontrada/{id}")
    public void DeleteFormMascotaEncontrada(@PathVariable Integer id) {
        formService.DeleteFormMascotaEncontrada(id);
    }


    /*
        Form Intencion Adopcion
    */
    @GetMapping("/intencionAdopcion")
    public Iterable<FormularioIntencionAdopcion> GetFormsIntencionAdopcion() {
        return formService.GetFormsIntencionAdopcion();
    }

    @GetMapping("/intencionAdopcion/{id}")
    public FormularioIntencionAdopcion GetFormIntencionAdopcionById(@PathVariable Integer id) {
        return formService.GetFormIntencionAdopcionById(id);
    }

    @PostMapping("/intencionAdopcion")
    public FormularioIntencionAdopcion CreateFormIntencionAdopcion(@RequestBody FormularioIntencionAdopcion form) {
        return formService.CreateFormIntencionAdopcion(form);
    }

    @PutMapping("/intencionAdopcion/{id}")
    public FormularioIntencionAdopcion UpdateFormIntencionAdopcion(@RequestBody FormularioIntencionAdopcion form, @PathVariable Integer id) {
        return formService.UpdateFormIntencionAdopcion(form, id);
    }

    @DeleteMapping("/intencionAdopcion/{id}")
    public void DeleteFormIntencionAdopcion(@PathVariable Integer id) {
        formService.DeleteFormIntencionAdopcion(id);
    }


    /*
        Form Dar En Adopcion
    */
    @GetMapping("/darEnAdopcion")
    public Iterable<FormularioDarEnAdopcion> GetFormsDarEnAdopcion() {
        return formService.GetFormsDarEnAdopcion();
    }

    @GetMapping("/darEnAdopcion/{id}")
    public FormularioDarEnAdopcion GetFormDarEnAdopcionById(@PathVariable Integer id) {
        return formService.GetFormDarEnAdopcionById(id);
    }

    @PostMapping("/darEnAdopcion")
    public FormularioDarEnAdopcion CreateFormDarEnAdopcion(@RequestBody FormularioDarEnAdopcion form) {
        return formService.CreateFormDarEnAdopcion(form);
    }

    @PutMapping("/darEnAdopcion/{id}")
    public FormularioDarEnAdopcion UpdateFormDarEnAdopcion(@RequestBody FormularioDarEnAdopcion form, @PathVariable Integer id) {
        return formService.UpdateFormDarEnAdopcion(form, id);
    }

    @DeleteMapping("/darEnAdopcion/{id}")
    public void DeleteFormDarEnAdopcion(@PathVariable Integer id) {
        formService.DeleteFormDarEnAdopcion(id);
    }
}
