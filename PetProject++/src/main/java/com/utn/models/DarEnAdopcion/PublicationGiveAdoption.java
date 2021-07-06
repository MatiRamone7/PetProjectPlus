package com.utn.models.DarEnAdopcion;

import org.omg.CORBA.PUBLIC_MEMBER;
import sun.security.util.BitArray;

import java.util.Date;
import java.util.List;

public class PublicationGiveAdoption {
    //Datos de contacto del Dueño
    private String nombreYApellido;
    private String telefono;
    private String mail;
    //TODO: Preguntar por decision de diseño sobre que datos del usuario mostrar o si nosotros deberiamos enviar una notificacion


    //Datos mascota
    private String especie;
    private String nombreMascota;
    private String apodoMascota;
    private Date edadAproximada;
    private String sexo;

    private List<BitArray> fotos; //TODO: Ver como cambiar a una direccion para que lo lea el HTML.
    //  Descripcion Fisica
    private String descripcion;
    private String raza;
    private String colorPrincipal;
    private String colorSecundario;
    private Boolean esterilizado;
    private Boolean rabo;
    private Boolean discapacidad;
    private String patronDistintivo;
    private String tamanio;
//  Descripcion Fisica


    public PublicationGiveAdoption(){}
    public PublicationGiveAdoption(String nombreYApellido, String telefono, String mail, String especie, String nombreMascota, String apodoMascota, Date edadAproximada, String sexo, List<BitArray> fotos, String descripcion, String raza, String colorPrincipal, String colorSecundario, Boolean esterilizado, Boolean rabo, Boolean discapacidad, String patronDistintivo, String tamanio) {
        this.nombreYApellido = nombreYApellido;
        this.telefono = telefono;
        this.mail = mail;
        this.especie = especie;
        this.nombreMascota = nombreMascota;
        this.apodoMascota = apodoMascota;
        this.edadAproximada = edadAproximada;
        this.sexo = sexo;
        this.fotos = fotos;
        this.descripcion = descripcion;
        this.raza = raza;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.esterilizado = esterilizado;
        this.rabo = rabo;
        this.discapacidad = discapacidad;
        this.patronDistintivo = patronDistintivo;
        this.tamanio = tamanio;
    }

    public void informarMascotaEncontrada(){
        //deberia tener el ID del formulario para poder enviarle la notificacion?
    }

}
