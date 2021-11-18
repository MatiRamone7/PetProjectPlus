package com.utn.controllers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.utn.models.contactservices.mensajesPredeterminados.IMensajePredet;
import com.utn.models.forms.Ciudad;
import com.utn.models.forms.Direccion;
import com.utn.models.forms.Provincia;
import com.utn.models.users.ContactoUnico;
import com.utn.models.users.Sesion;
import com.utn.models.users.TipoDocumento;
import com.utn.models.users.Usuario;
import com.utn.services.IGeoService;
import com.utn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IGeoService geoService;

    @GetMapping
    public Iterable<Usuario> GetUsers() {
        return userService.GetUsers();
    }

    @GetMapping("/{id}")
    public Usuario GetUserById(@PathVariable Integer id) {
        return userService.GetUserById(id);
    }

    @PostMapping("/json")
    public Usuario Create(@RequestBody Usuario user) {
        return userService.Create(user);
    }

/*
    @RequestMapping(method = RequestMethod.POST,
            consumes = {"application/x-www-form-urlencoded"})
    public void Creates(@RequestBody Usuario user) {
        userService.Create(user);
    }*/

    @PostMapping
    public void Create(@RequestParam Map<String, String> body, HttpServletResponse response) throws IOException {
        System.out.println("ENTRA A CREATE");
        Usuario user = new Usuario();
        user.setNombre(body.get("nombre"));
        user.setApellido(body.get("apellido"));
        user.setTipoDocumento(TipoDocumento.valueOf(body.get("tipoDocumento")));

        Sesion sesion = new Sesion(body.get("sesion.username"),body.get("sesion.password"));
        user.setSesion(sesion);
        user.setFechaNacimiento(LocalDate.parse(body.get("fechaNacimiento")));

        Direccion direccion = new Direccion();
        direccion.setCalle(body.get("direccion.calle"));
        direccion.setDepartamento(body.get("direccion.departamento"));
        direccion.setCodigoPostal(body.get("direccion.codigoPostal"));

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(body.get("direccion.ciudad.nombre"));

        Provincia provincia = new Provincia();
        try{
            user.setNroDocumento(Integer.parseInt(body.get("nroDocumento")));
            direccion.setNumero(Integer.parseInt(body.get("direccion.numero")));
            provincia.setId(Integer.valueOf(body.get("direccion.ciudad.provincia.id")));
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        ciudad.setProvincia(provincia);
        //ciudad.setProvincia(geoService.GetProvinciaById(Integer.valueOf(body.get("direccion.ciudad.provincia.id"))));
        direccion.setCiudad(ciudad);
        user.setDireccion(direccion);

        ContactoUnico contacto = new ContactoUnico(body.get("contacto.mail"), body.get("contacto.celular"));
        user.setContacto(contacto);

        userService.Create(user);

        response.sendRedirect("/Inicio");
    }

    @PutMapping("/{id}")
    public Usuario Update(@RequestBody Usuario user, @PathVariable Integer id) {
        return userService.Update(user, id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id) {
        userService.Delete(id);
    }

    @GetMapping("/notificarUsuario/{id}")
    public void NotifyUser(@RequestBody Map<String, Object> datos, @PathVariable Integer id) throws IOException {
        Usuario user = this.GetUserById(id);

        IMensajePredet mensaje = new IMensajePredet() {
            @Override
            public String cuerpo() {
                return (String) datos.get("cuerpo");
            }

            @Override
            public String asunto() {
                return (String) datos.get("asunto");
            }

            @Override
            public void cambiarTexto(String input) {

            }
        };

        user.contactar(mensaje);
    }
}
