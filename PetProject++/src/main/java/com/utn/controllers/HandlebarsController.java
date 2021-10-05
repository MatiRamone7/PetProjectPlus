package com.utn.controllers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.utn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//NOMENCLATURA PARA MAPPINGS
//TODO: JSON-> en inglés, in english  // HTML -> en español, in spanish
@RestController
@RequestMapping("/")
public class HandlebarsController {

    @Autowired
    IUserService userService;

    /**EJEMPLO DE COMO SINCRONIZAMOS HANDLEBARS CON SPRING*/
    @GetMapping("usuario")
    public String GetUsers() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);       //se crea la instancia de handlebars
        Template template = handlebars.compile("mascotaPerdida");  //se crea el template sobre el .hbs que querés enviar (ej: formularioUsuario.hbs)
        Map<String, Object> model = new HashMap<>();    //en este map se ponen todas las variables o clases que quieras usar luego en el handlebars
        model.put("usuarios", userService.GetUsers());  //acá pones las cosas dentro del map (en este ejemplo estoy poniendo una lista de usuarios
        //con una etiqueta llama "usuarios)

        return template.apply(model);                   //aplicas las variables del template y las envías
    }

}
