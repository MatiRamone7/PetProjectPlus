package com.utn.models.MascotaPerdida;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;
import com.utn.models.TransitHomes.Ubication;

import java.util.List;

public class PublicationLostPet {
    private String descripcion;
    private String especie;
    private String raza;
    private String sexo;
    private String colorPrincipal;
    private String colorSecundario;
    private Boolean esterilizado;
    private Boolean rabo;
    private Boolean discapacidad;
    private String patronDistintivo;
    private String tamanio;
    private Ubication lugarEncontrado;
    private List<String> caracteristicasDeLaPublicacion;
    private List<BitArray> fotos;

    public PublicationLostPet(){}
    public PublicationLostPet(String descripcion, String especie, String raza, String sexo, String colorPrincipal, String colorSecundario, Boolean esterilizado, Boolean rabo, Boolean discapacidad, String patronDistintivo, String tamanio, Ubication lugarEncontrado, List<String> caracteristicasDeLaPublicacion, List<BitArray> fotos) {
        this.descripcion = descripcion;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.esterilizado = esterilizado;
        this.rabo = rabo;
        this.discapacidad = discapacidad;
        this.patronDistintivo = patronDistintivo;
        this.tamanio = tamanio;
        this.lugarEncontrado = lugarEncontrado;
        this.caracteristicasDeLaPublicacion = caracteristicasDeLaPublicacion;
        this.fotos = fotos;
    }


    public void informarMascotaEncontrada(){

        //deberia tener el ID del formulario para poder enviarle la notificacion?
    }
}
