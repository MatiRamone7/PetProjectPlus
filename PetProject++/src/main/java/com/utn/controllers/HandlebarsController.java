package com.utn.controllers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.forms.FormularioMascotaPerdida;
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
        List<FormularioDarEnAdopcion> formulariosMascotas = new ArrayList<FormularioDarEnAdopcion>();
        formService.GetFormsDarEnAdopcion().forEach(formulariosMascotas::add);
        //petService.GetPets().forEach(mascotas::add); //TODO: solo mascotas en adopción - Traer los formularios dar en adopcion

        class MascotaFoto{
            Mascota mascota;
            String foto;
            Integer formId;

            public MascotaFoto(Mascota mascota, String foto, Integer formId) {
                this.mascota = mascota;
                this.foto = foto;
                this.formId = formId;
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

            public Integer getFormId() {
                return formId;
            }

            public void setFormId(Integer formId) {
                this.formId = formId;
            }

        }

        class ConjuntoMascotas{
            boolean active;
            List<MascotaFoto> mascotaFoto;

            public boolean isActive() {
                return active;
            }

            public void setActive(boolean active) {
                this.active = active;
            }

            public List<MascotaFoto> getMascotaFoto() {
                return mascotaFoto;
            }

            public void setMascotaFoto(List<MascotaFoto> mascotaFoto) {
                this.mascotaFoto = mascotaFoto;
            }

            public ConjuntoMascotas(boolean active, List<MascotaFoto> mascotaFoto) {
                this.active = active;
                this.mascotaFoto = mascotaFoto;
            }
        }
        List<FormularioDarEnAdopcion> formsPerros = formulariosMascotas.stream().filter(a -> a.getMascota().getEspecie() == Especie.PERRO).collect(Collectors.toList());

                //mascotas.stream().filter(a -> a.getEspecie() == Especie.PERRO).collect(Collectors.toList());
        List<ConjuntoMascotas> conjuntoPerros = new ArrayList<>();
        for (int i = 0; i < formsPerros.size();) {
            List<MascotaFoto> pets = new ArrayList<>();
            for (int y = 0; y < 3 && i < formsPerros.size(); y++) {
                Mascota unPerro = formsPerros.get(i).getMascota();

                pets.add(new MascotaFoto(unPerro,
                        Base64Utils.encodeToString(
                            unPerro.getFotos().stream().findFirst().get().getImagenByteArray()
                        ),
                        formsPerros.get(i).getId()));
                i++;
            }
            if(i<4){
                conjuntoPerros.add(new ConjuntoMascotas(true, pets));
            }
            else{
                conjuntoPerros.add(new ConjuntoMascotas(false, pets));
            }
        }

        List<FormularioDarEnAdopcion> formsGatos = formulariosMascotas.stream().filter(a -> a.getMascota().getEspecie() == Especie.GATO).collect(Collectors.toList());
        List<ConjuntoMascotas> conjuntoGatos = new ArrayList<>();
        for (int i = 0; i < formsGatos.size();) {
            List<MascotaFoto> pets = new ArrayList<>();
            for (int y = 0; y < 3 && i < formsGatos.size(); y++) {
                Mascota unGato = formsGatos.get(i).getMascota();

                pets.add(new MascotaFoto(unGato,
                        Base64Utils.encodeToString(
                                unGato.getFotos().stream().findFirst().get().getImagenByteArray()
                        ),
                        formsGatos.get(i).getId()));
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
        model.put("mascotaId", petId);

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



        List<FormularioMascotaPerdida> formulariosMascotas = new ArrayList<FormularioMascotaPerdida>();
        formService.GetFormsMascotaPerdida().forEach(formulariosMascotas::add);
        //petService.GetPets().forEach(mascotas::add); //TODO: solo mascotas en adopción - Traer los formularios dar en adopcion

        class MascotaFoto{
            FormularioMascotaPerdida mascota;
            String foto;

            public MascotaFoto(FormularioMascotaPerdida mascota, String foto) {
                this.mascota = mascota;
                this.foto = foto;
            }

            public FormularioMascotaPerdida getMascota() {
                return mascota;
            }

            public void setMascota(FormularioMascotaPerdida mascota) {
                this.mascota = mascota;
            }

            public String getFoto() {
                return foto;
            }

            public void setFoto(String foto) {
                this.foto = foto;
            }
        }

        class ConjuntoMascotas{
            boolean active;
            List<MascotaFoto> mascotaFoto;

            public boolean isActive() {
                return active;
            }

            public void setActive(boolean active) {
                this.active = active;
            }

            public List<MascotaFoto> getMascotaFoto() {
                return mascotaFoto;
            }

            public void setMascotaFoto(List<MascotaFoto> mascotaFoto) {
                this.mascotaFoto = mascotaFoto;
            }

            public ConjuntoMascotas(boolean active, List<MascotaFoto> mascotaFoto) {
                this.active = active;
                this.mascotaFoto = mascotaFoto;
            }
        }
        List<FormularioMascotaPerdida> formsPerros = formulariosMascotas.stream().filter(a -> a.getEspecie() == Especie.PERRO && a.getMascota() == null).collect(Collectors.toList());

        //mascotas.stream().filter(a -> a.getEspecie() == Especie.PERRO).collect(Collectors.toList());
        List<ConjuntoMascotas> conjuntoPerros = new ArrayList<>();
        for (int i = 0; i < formsPerros.size();) {
            List<MascotaFoto> pets = new ArrayList<>();
            for (int y = 0; y < 3 && i < formsPerros.size(); y++) {
                FormularioMascotaPerdida unPerro = formsPerros.get(i);

                pets.add(new MascotaFoto(unPerro,
                        Base64Utils.encodeToString(
                                unPerro.getFotos().stream().findFirst().get().getImagenByteArray()
                        )));
                i++;
            }
            if(i<4){
                conjuntoPerros.add(new ConjuntoMascotas(true, pets));
            }
            else{
                conjuntoPerros.add(new ConjuntoMascotas(false, pets));
            }
        }

        List<FormularioMascotaPerdida> formsGatos = formulariosMascotas.stream().filter(a -> a.getEspecie() == Especie.GATO && a.getMascota() == null).collect(Collectors.toList());
        List<ConjuntoMascotas> conjuntoGatos = new ArrayList<>();
        for (int i = 0; i < formsGatos.size();) {
            List<MascotaFoto> pets = new ArrayList<>();
            for (int y = 0; y < 3 && i < formsGatos.size(); y++) {
                FormularioMascotaPerdida unGato = formsGatos.get(i);

                pets.add(new MascotaFoto(unGato,
                        Base64Utils.encodeToString(
                                unGato.getFotos().stream().findFirst().get().getImagenByteArray()
                        )));
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



        return template.apply(model);
    }

    @GetMapping("Mascotas-Encontradas/{id}")
    public String GetDetalleMascotaEncontrada(@PathVariable Integer id) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("detalle-mascota-encontrada");
        Map<String, Object> model = new HashMap<>();
        FormularioMascotaPerdida form = formService.GetFormMascotaPerdidaById(id);
        model.put("formMascotaPerdida", form);
        List<String> fotos = new ArrayList<>();
        List<Foto> fotosClase = form.getFotos();
        for(int i = 0; i < fotosClase.size(); i++){
            fotos.add(Base64Utils.encodeToString(fotosClase.get(i).getImagenByteArray()));
        }
        model.put("fotos", fotos);


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

    @GetMapping("Mascota-Perdida/{id}")
    public String GetMascotaPerdidaByID(@PathVariable Integer id) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("mascotaPerdidaByID");

        Map<String, Object> model = new HashMap<>();
        model.put("provincias", geoService.GetProvincias());

        Mascota mascota = petService.GetPetById(id);
        model.put("mascota", mascota);

        return template.apply(model);
    }
}

