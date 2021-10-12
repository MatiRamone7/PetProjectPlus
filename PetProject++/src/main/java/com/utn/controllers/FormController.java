package com.utn.controllers;

import com.utn.models.forms.*;
import com.utn.models.users.ContactoUnico;
import com.utn.models.users.Sesion;
import com.utn.models.users.TipoDocumento;
import com.utn.services.IFormService;
import com.utn.services.IPetService;
import com.utn.transithomes.Hogar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/forms")
public class FormController {

    /*
        Form FormularioMascotaPerdida Perdida
    */
    @Autowired
    IFormService formService;

    @Autowired
    IPetService petService;

    public FormController(IFormService formService) {
        this.formService = formService;
    }

    @GetMapping("/mascotaPerdida")
    public Iterable<FormularioMascotaPerdida> GetFormsMascotaPerdida() {
        return formService.GetFormsMascotaPerdida();
    }

    @GetMapping("/mascotaPerdida/{id}")
    public FormularioMascotaPerdida GetFormMascotaPerdidaById(@PathVariable Integer id) {
        return formService.GetFormMascotaPerdidaById(id);
    }

    @PostMapping("/mascotaPerdida/json")
    public FormularioMascotaPerdida CreateFormMascotaPerdida(@RequestBody FormularioMascotaPerdida form) {
        return formService.CreateFormMascotaPerdida(form);
    }

    @PostMapping("/mascotaPerdida")
    public void CreateFormMascotaPerdida(@RequestParam Map<String, String> body, HttpServletResponse response) throws IOException {
        FormularioMascotaPerdida form = new FormularioMascotaPerdida();

        System.out.println(body.get("caracteristicasHogares"));

        form.setCaracteristicasDeLaPublicacionDelHogar(Hogar.asignarCaracteristicasHogar(body));


        form.setNombre(body.get("nombre"));
        form.setApellido(body.get("apellido"));
        form.setTipoDocumento(TipoDocumento.valueOf(body.get("tipoDocumento")));

        form.setFechaNacimiento(LocalDate.parse(body.get("fechaNacimiento")));

        Direccion direccion = new Direccion();
        direccion.setCalle(body.get("direccion.calle"));
        direccion.setDepartamento(body.get("direccion.departamento"));
        direccion.setCodigoPostal(body.get("direccion.codigoPostal"));

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(body.get("direccion.ciudad.nombre"));

        Provincia provincia = new Provincia();
        try{
            form.setNroDocumento(Integer.parseInt(body.get("nroDocumento")));
            direccion.setNumero(Integer.parseInt(body.get("direccion.numero")));
            provincia.setId(Integer.valueOf(body.get("direccion.ciudad.provincia.id")));
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        ciudad.setProvincia(provincia);
        //ciudad.setProvincia(geoService.GetProvinciaById(Integer.valueOf(body.get("direccion.ciudad.provincia.id"))));
        direccion.setCiudad(ciudad);
        form.setDireccion(direccion);

        ContactoUnico contacto = new ContactoUnico(body.get("contacto.mail"), body.get("contacto.celular"));
        form.setContacto(contacto);
        List<String> caracteristicasHogar = new ArrayList<>();


        if(body.get("mascota") != null){
            form.setMascota(petService.GetPetById(Integer.valueOf(body.get("mascota"))));
        }
        else{

        }



        //formService.CreateFormMascotaPerdida(form);
        response.sendRedirect("/Inicio");
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
