package com.utn.transithomes.MascotaPerdida;


import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

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
    private double lat;
    private double lon;
    private List<String> caracteristicasDeLaPublicacion;
    private List<BitArray> fotos;

    public PublicationLostPet(){}
    public PublicationLostPet(String descripcion, String especie, String raza, String sexo, String colorPrincipal, String colorSecundario, Boolean esterilizado, Boolean rabo, Boolean discapacidad, String patronDistintivo, String tamanio, double lat, double lon, List<String> caracteristicasDeLaPublicacion, List<BitArray> fotos) {
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
        this.lat = lat;
        this.lon = lon;
        this.caracteristicasDeLaPublicacion = caracteristicasDeLaPublicacion;
        this.fotos = fotos;
    }


    public void informarMascotaEncontrada(){

        //deberia tener el ID del formulario para poder enviarle la notificacion?
    }
}
