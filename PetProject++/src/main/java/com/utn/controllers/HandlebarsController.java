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



    // NUEVOS HBS AGREGADOS
    @GetMapping("Dar-en-Adopcion")
    public String GetDarEnAdopcion() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("dar-en-adopcion");

        return template.text();
    }

    @GetMapping("Detalle-Mascota-Encontrada")
    public String GetDetalleMascotaEncontrada() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("detalle-mascota-encontrada");

        return template.text();
    }

    @GetMapping("Editor-de-Formularios")
    public String GetEditorDeFormularios() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("editor_de_formularios");

        return template.text();
    }

    @GetMapping("Formulario-Quiero-Adoptar")
    public String GetFormularioQuieroAdoptar() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("formularioQuieroAdoptar");

        return template.text();
    }

    @GetMapping("Formulario-Usuario")
    public String GetFormularioUsuario() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("formularioUsuario");

        return template.text();
    }

    @GetMapping("Hogares-Transito")
    public String GetHogaresTransito() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("hogares-transito");

        return template.text();
    }

    @GetMapping("Log-In")
    public String GetLogIn() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("logIn");

        return template.text();
    }

    @GetMapping("Mascota-Perdida")
    public String GetMascotasPerdidas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);       //se crea la instancia de handlebars
        Template template = handlebars.compile("mascotaPerdida");  //se crea el template sobre el .hbs que querés enviar (ej: formularioUsuario.hbs)

        return template.text();                   //aplicas las variables del template y las envías
    }

    @GetMapping("Mascotas-Encontradas")
    public String GetMascotasEncontradas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("mascotas-encontradas");

        return template.text();
    }

    @GetMapping("Admin-Perfiles-ONG")
    public String GetAdminPerfilesONG() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("pantallaAdmin");

        return template.text();
    }

    @GetMapping("Admin-Preguntas-ONG")
    public String GetAdminPreguntasONG() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("pantallaAdmin2");

        return template.text();
    }

    @GetMapping("Perfil-Usuario")
    public String GetPerfilUsuario() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("perfil");

        return template.text();
    }

    @GetMapping("Registrar-Mascota")
    public String GetRegistrarMascota() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("registrarMascota");

        return template.text();
    }
}
