package com.utn.controllers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.utn.models.mascotas.Mascota;
import com.utn.services.IPetService;
import com.utn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//NOMENCLATURA PARA MAPPINGS
//TODO: JSON-> en inglés, in english  // HTML -> en español, in spanish
@RestController
@RequestMapping("/")
public class HandlebarsController {

    @Autowired
    IUserService userService;

    @Autowired
    IPetService petService;


    @GetMapping("Adopcion-de-Mascotas")
    public String GetAdopcionMasotas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);       //se crea la instancia de handlebars
        Template template = handlebars.compile("adopcion-mascotas");  //se crea el template sobre el .hbs que querés enviar (ej: formularioUsuario.hbs)
        Map<String, Object> model = new HashMap<>();    //en este map se ponen todas las variables o clases que quieras usar luego en el handlebars
        List<Mascota> mascotas = new ArrayList<Mascota>();
        petService.GetPets().forEach(mascotas::add); //TODO: solo mascotas en adopción
        model.put("mascotas1", mascotas.subList(0, (int)(mascotas.size()/2)));
        model.put("mascotas2", mascotas.subList((int)(mascotas.size()/2 + 1), mascotas.size()));//acá pones las cosas dentro del map (en este ejemplo estoy poniendo una lista de usuarios
                                                                                                //con una etiqueta llama "mascotas")
        return template.apply(model);                   //aplicas las variables del template y las envías
    }

    /**EJEMPLO DE COMO SINCRONIZAMOS HANDLEBARS CON SPRING*/
    @GetMapping("Mascota-Perdida")
    public String GetMascotasPerdidas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);       //se crea la instancia de handlebars
        Template template = handlebars.compile("mascotaPerdida");  //se crea el template sobre el .hbs que querés enviar (ej: formularioUsuario.hbs)

        return template.text();                   //aplicas las variables del template y las envías
    }

    @GetMapping("Log-In")
    public String GetLogIn() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);       //se crea la instancia de handlebars
        Template template = handlebars.compile("logIn");  //se crea el template sobre el .hbs que querés enviar (ej: formularioUsuario.hbs)

        return template.text();                   //aplicas las variables del template y las envías
    }


}
