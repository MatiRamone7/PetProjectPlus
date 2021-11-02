package com.utn.controllers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.utn.models.forms.Foto;
import com.utn.models.mascotas.Caracteristica;
import com.utn.models.mascotas.Mascota;
import com.utn.models.mascotas.Mascota.Especie;
import com.utn.models.users.Usuario;
import com.utn.services.*;
import com.utn.transithomes.AdapterApiRestHogaresDeTransito;
import com.utn.transithomes.AdapterRefugios;
import javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//NOMENCLATURA PARA MAPPINGS
//TODO: JSON-> en inglés, in english  // HTML -> en español, in spanish
@RestController
@RequestMapping("/")
public class HandlebarsController {

    @Autowired
    IUserService userService;

    @Autowired
    IPetService petService;

    @Autowired
    IFormService formService;

    @Autowired
    IGeoService geoService;

    @Autowired
    ICaracteristicaService caracteristicaService;

    @Autowired
    IOngService ongService;


    @GetMapping("Adopcion-de-Mascotas")
    public String GetAdopcionMasotas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);       //se crea la instancia de handlebars
        Template template = handlebars.compile("adopcion-mascotas");  //se crea el template sobre el .hbs que querés enviar (ej: formularioUsuario.hbs)
        Map<String, Object> model = new HashMap<>();    //en este map se ponen todas las variables o clases que quieras usar luego en el handlebars
        List<Mascota> mascotas = new ArrayList<Mascota>();
        petService.GetPets().forEach(mascotas::add); //TODO: solo mascotas en adopción - Traer los formularios dar en adopcion

        class ConjuntoMascotas{
            boolean active;
            List<Mascota> mascotas;

            public boolean isActive() {
                return active;
            }

            public void setActive(boolean active) {
                this.active = active;
            }

            public List<Mascota> getMascotas() {
                return mascotas;
            }

            public void setMascotas(List<Mascota> mascotas) {
                this.mascotas = mascotas;
            }

            public ConjuntoMascotas(boolean active, List<Mascota> mascotas) {
                this.active = active;
                this.mascotas = mascotas;
            }
        }
        List<Mascota> perros = mascotas.stream().filter(a -> a.getEspecie() == Especie.PERRO).collect(Collectors.toList());
        List<ConjuntoMascotas> conjuntoPerros = new ArrayList<>();
        for (int i = 0; i < perros.size(); i++) {
            List<Mascota> pets = new ArrayList<>();
            for (int y = 0; y < 3 && i < perros.size(); y++) {
                pets.add(perros.get(i));
                i++;
            }
            if(i<4){
                conjuntoPerros.add(new ConjuntoMascotas(true, pets));
            }
            else{
                conjuntoPerros.add(new ConjuntoMascotas(false, pets));
            }
        }

        List<Mascota> gatos = mascotas.stream().filter(a -> a.getEspecie() == Especie.GATO).collect(Collectors.toList());
        List<ConjuntoMascotas> conjuntoGatos = new ArrayList<>();
        for (int i = 0; i < gatos.size(); i++) {
            List<Mascota> pets = new ArrayList<>();
            for (int y = 0; y < 3 && i < gatos.size(); y++) {
                pets.add(gatos.get(i));
                i++;
            }
            if(i<4){
                conjuntoGatos.add(new ConjuntoMascotas(true, pets));
            }
            else{
                conjuntoGatos.add(new ConjuntoMascotas(false, pets));
            }
        }

        model.put("perros", conjuntoPerros);
        model.put("gatos", conjuntoGatos);



        return template.apply(model);                   //aplicas las variables del template y las envías
    }

    /**EJEMPLO DE COMO SINCRONIZAMOS HANDLEBARS CON SPRING*/



    // NUEVOS HBS AGREGADOS
    @GetMapping("Dar-en-Adopcion/{petId}")
    public String GetDarEnAdopcion(@PathVariable Integer petId) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("dar-en-adopcion");

        Map<String, Object> model = new HashMap<>();
        model.put("preguntasDarEnAdopcion", petService.GetPetById(petId).getDuenio().getOrganizacion().getPreguntasDarEnAdopcion());

        return template.apply(model);
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

        Map<String, Object> model = new HashMap<>();
        model.put("provincias", geoService.GetProvincias());

        return template.apply(model);
    }

    @GetMapping("Hogares-Transito")
    public String GetHogaresTransito(@RequestParam Map<String, String> body) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("hogares-transito");

        Map<String, Object> model = new HashMap<>();
        AdapterRefugios adapter = AdapterApiRestHogaresDeTransito.getInstancia();
        model.put("hogares", adapter.obtenerHogaresTransito());

        return template.apply(model);
    }

    @GetMapping("Inicio")
    public String GetInicio() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("inicio");

        return template.text();
    }

    @GetMapping("Mascota-Perdida")
    public String GetMascotasPerdidas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);       //se crea la instancia de handlebars
        Template template = handlebars.compile("mascotaPerdida");  //se crea el template sobre el .hbs que querés enviar (ej: formularioUsuario.hbs)
        Map<String, Object> model = new HashMap<>();
        model.put("provincias", geoService.GetProvincias());
        model.put("caracteristicas", caracteristicaService.GetCaracteristicas());

        return template.apply(model);                   //aplicas las variables del template y las envías
    }

    @GetMapping("Mascotas-Encontradas")
    public String GetMascotasEncontradas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("mascotas-encontradas");
        Map<String, Object> model = new HashMap<>();
        model.put("formMascotaPerdida", formService.GetFormsMascotaPerdida());

        return template.apply(model);
    }

    @GetMapping("Mascotas-Encontradas/{id}")
    public String GetDetalleMascotaEncontrada(@PathVariable Integer id) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("detalle-mascota-encontrada");
        Map<String, Object> model = new HashMap<>();
        model.put("formMascotaPerdida", formService.GetFormMascotaPerdidaById(id));

        return template.apply(model);
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

    @GetMapping("Perfil/{userId}")
    public String GetPerfilUsuario(@PathVariable Integer userId) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("perfil");

        class CarrouselMascotas{
            boolean active;
            Mascota mascota;
            String foto;

            public CarrouselMascotas(boolean active, Mascota mascota, String foto) {
                this.active = active;
                this.mascota = mascota;
                this.foto = foto;
            }

            public boolean isActive() {
                return active;
            }

            public void setActive(boolean active) {
                this.active = active;
            }

            public Mascota getMascota() {
                return mascota;
            }

            public void setMascota(Mascota mascota) {
                this.mascota = mascota;
            }

            public String getFoto() {
                return foto;
            }

            public void setFoto(String foto) {
                this.foto = foto;
            }
        }

        Map<String, Object> model = new HashMap<>();
        Usuario usuario = userService.GetUserById(userId);
        model.put("usuario", usuario);
        List<CarrouselMascotas> carrousel = new ArrayList<>();
        List<Mascota> mascotas = usuario.getMascotas().stream().collect(Collectors.toList());
        for(int i = 0; i < usuario.getMascotas().size(); i++){
            boolean activo;
            if(i == 0) {
                activo = true;
            }
            else{
                activo = false;
            }
            carrousel.add(new CarrouselMascotas(activo,
                    mascotas.get(i),
                    Base64Utils.encodeToString(
                            mascotas.get(i).getFotos().stream().findFirst().get().getImagenByteArray()
                    )));
        }
        model.put("carrousel", carrousel);

        return template.apply(model);
    }

    @GetMapping("Preguntas-Mascotas")
    public String GetPreguntasMascotas() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("preguntas-caracteristicas-mascotas");
        Map<String, Object> model = new HashMap<>();
        model.put("caracteristicas", caracteristicaService.GetCaracteristicas());

        return template.apply(model);
    }

    @GetMapping("Preguntas-Mascotas/Respuestas/{preguntaId}")
    public String GetPreguntasMascotas(@PathVariable Integer preguntaId) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("respuestas-preguntas-caracteristicas-mascotas");
        Map<String, Object> model = new HashMap<>();
        Caracteristica caracteristica = caracteristicaService.GetCaracteristicaById(preguntaId);
        model.put("caracteristicaFiltrable", caracteristica.getOpciones());
        model.put("caracteristica", caracteristica);

        return template.apply(model);
    }

    @GetMapping("Registrar-Mascota/{duenioId}")
    public String GetRegistrarMascota(@PathVariable Integer duenioId) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("registrarMascota");
        Map<String, Object> model = new HashMap<>();
        model.put("caracteristicas", caracteristicaService.GetCaracteristicas());
        model.put("duenioId", duenioId);

        return template.apply(model);
    }

    @GetMapping("Sign-Up")
    public String GetLogIn() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("signUp");

        return template.text();
    }
}

