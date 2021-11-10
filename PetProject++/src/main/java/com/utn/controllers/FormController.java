package com.utn.controllers;

import com.utn.models.contactservices.mensajesPredeterminados.CInteresDeAdopcion;
import com.utn.models.contactservices.mensajesPredeterminados.CMascotaReconocida;
import com.utn.models.contactservices.mensajesPredeterminados.CQRScaneado;
import com.utn.models.forms.*;
import com.utn.models.mascotas.Caracteristica;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.ongs.PreguntaAdoptante;
import com.utn.models.users.ContactoUnico;
import com.utn.models.users.Sesion;
import com.utn.models.users.TipoDocumento;
import com.utn.services.ICaracteristicaService;
import com.utn.services.IFormService;
import com.utn.services.IOngService;
import com.utn.services.IPetService;
import com.utn.transithomes.Hogar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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

    @Autowired
    ICaracteristicaService caracteristicaService;

    @Autowired
    IOngService ongService;

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
    public void CreateFormMascotaPerdida(@RequestParam Map<String, String> body, @RequestParam("imagen") MultipartFile img, HttpServletResponse response) throws IOException {
        FormularioMascotaPerdida form = new FormularioMascotaPerdida();


        List<Foto> fotos = new ArrayList<>();
        fotos.add(new Foto(img.getBytes(), img.getName()));
        form.setFotos(fotos);


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
        form.setCaracteristicasDeLaPublicacionDelHogar(Hogar.asignarCaracteristicasHogar(body));


        form.setEspecie(Mascota.Especie.valueOf(body.get("especie")));
        form.setSexo(Mascota.Sexo.valueOf(body.get("sexo")));

        Iterable<Caracteristica> caracteristicas = caracteristicaService.GetCaracteristicas();
        Set<CaracteristicaPet> caracteristicasPets = new HashSet<>();
        for(Caracteristica caracteristica : caracteristicas){
            if(!body.get(caracteristica.getDescripcion()).isEmpty()) {
                CaracteristicaPet caracteristicaPet = new CaracteristicaPet();
                Caracteristica caract = new Caracteristica();
                caract.setId(caracteristica.getId());
                caracteristicaPet.setTipoCaracteristica(caract);
                caracteristicaPet.setValor(body.get(caracteristica.getDescripcion()));
                caracteristicasPets.add(caracteristicaPet);
            }
        }
        form.setCaracteristicas(caracteristicasPets);



        form.setDescripcion(body.get("descripcion"));
        //form.setLugarEncuentroMascota(body.get("lugarEncuentroMascota"));

        formService.CreateFormMascotaPerdida(form);
        response.sendRedirect("/Hogares-Transito");
    }

    @PostMapping("/mascotaPerdida/{id}")
    public void CreateFormMascotaPerdidaByID(@RequestParam Map<String, String> body, @RequestParam("imagen") MultipartFile img,  @PathVariable Integer id, HttpServletResponse response) throws IOException {
        FormularioMascotaPerdida form = new FormularioMascotaPerdida();
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
        direccion.setCiudad(ciudad);
        form.setDireccion(direccion);

        ContactoUnico contacto = new ContactoUnico(body.get("contacto.mail"), body.get("contacto.celular"));
        form.setContacto(contacto);

        //Mascota mascota = petService.GetPetById(id);
        if(!body.get("mascota").isEmpty()){
            Mascota mascota = petService.GetPetById(id);
            form.setMascota(mascota);
            form.setEspecie(mascota.getEspecie());
            form.setSexo(mascota.getSexo());
            //form.setCaracteristicas(mascota.getCaracteristicSet());
        }

        form.setDescripcion(body.get("descripcion"));
        //form.setLugarEncuentroMascota(body.get("lugarEncuentroMascota"));
        //TODO esto
        formService.CreateFormMascotaPerdida(form);
       /*System.out.println(form.getId().toString());
        if(!body.get("mascota").isEmpty()){
            Mascota mascota = petService.GetPetById(id);
            form.setCaracteristicas(mascota.getCaracteristicSet());
        }
        formService.UpdateFormMascotaPerdida(form,form.getId());*/
        CQRScaneado msg = new CQRScaneado(form);
        form.getMascota().getDuenio().contactar(msg);
        response.sendRedirect("/Hogares-Transito");
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
    
    @PostMapping("/mascotaEncontrada/{id}")
    public void notificarRescatista(@RequestParam Map<String, String> datos, @PathVariable Integer id, HttpServletResponse response) throws IOException {
        CMascotaReconocida mensaje = new CMascotaReconocida(datos.get("input"));

       try {
            formService.GetFormMascotaEncontradaById(id).getFormularioMascotaPerdida().getContacto().contactar(mensaje.asunto(), mensaje.cuerpo());
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Mascotas-Encontradas/"+ id.toString());
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

    @PostMapping("/darEnAdopcion/{mascotaId}")
    public void CreateFormDarEnAdopcion(@RequestParam Map<String, String> body, @PathVariable Integer mascotaId, HttpServletResponse response) throws IOException {
        FormularioDarEnAdopcion form = new FormularioDarEnAdopcion();
        Mascota mascota = petService.GetPetById(Integer.valueOf(mascotaId));

        form.setMascota(mascota);
        form.setUsuario(mascota.getDuenio());
        Organizacion organizacion = ongService.GetOngById(Integer.valueOf(body.get("organizacion")));
        form.setOrganizacion(organizacion);

        //Set<PreguntaAdoptante> preguntas = organizacion.getPreguntasDarEnAdopcion();
        List<PreguntaRespuestaAdoptante> respuestas = new ArrayList<>();

        Iterator<PreguntaAdoptante> preguntas = organizacion.getPreguntasDarEnAdopcion().iterator();
        while(preguntas.hasNext()){
            PreguntaAdoptante pregunta = preguntas.next();
            PreguntaRespuestaAdoptante respuesta = new PreguntaRespuestaAdoptante();
            respuesta.setPregunta(pregunta);
            respuesta.setRta(body.get(pregunta.getPregunta()));
            respuestas.add(respuesta);
        }

        form.setPreguntas(respuestas);

        formService.CreateFormDarEnAdopcion(form);
        response.sendRedirect("/Inicio");
    }


    @PutMapping("/darEnAdopcion/{id}")
    public FormularioDarEnAdopcion UpdateFormDarEnAdopcion(@RequestBody FormularioDarEnAdopcion form, @PathVariable Integer id) {
        return formService.UpdateFormDarEnAdopcion(form, id);
    }

    @DeleteMapping("/darEnAdopcion/{id}")
    public void DeleteFormDarEnAdopcion(@PathVariable Integer id) {
        formService.DeleteFormDarEnAdopcion(id);
    }

    @PostMapping("/darEnAdopcion/detalles/{id}")
    public void notificarDuenioActual(@RequestParam Map<String, String> datos, @PathVariable Integer id, HttpServletResponse response) throws IOException {
        CInteresDeAdopcion mensaje = new CInteresDeAdopcion(datos.get("input"));

        try {
            formService.GetFormDarEnAdopcionById(id).getUsuario().contactar(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
       response.sendRedirect("/Adopcion-de-Mascotas/" + id.toString());
    }
}
