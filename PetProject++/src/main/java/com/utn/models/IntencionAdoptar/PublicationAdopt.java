package com.utn.models.IntencionAdoptar;

import com.utn.models.MascotaPerdida.PublicationLostPet;

public class PublicationAdopt {
    //Datos de contacto del Dueño
    private String nombreYApellido;
    private String telefono;
    private String mail;

    //Datos sobre la mascota
    private String especie;
    private String raza;
    private String sexo;
    private String colorPrincipal;
    private String colorSecundario;
    private Boolean esterilizado;
    private Boolean rabo;
    private Boolean discapacidad;
    private String tamanio;


    public PublicationAdopt(){}
    public PublicationAdopt(String nombreYApellido, String telefono, String mail, String especie, String raza, String sexo, String colorPrincipal, String colorSecundario, Boolean esterilizado, Boolean rabo, Boolean discapacidad, String tamanio) {
        this.nombreYApellido = nombreYApellido;
        this.telefono = telefono;
        this.mail = mail;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.esterilizado = esterilizado;
        this.rabo = rabo;
        this.discapacidad = discapacidad;
        this.tamanio = tamanio;
    }

    public void informarMascotaEncontrada(){
        //deberia tener el ID del formulario para poder enviarle la notificacion?
        //mandar un mail para dar de baja
    }
}
