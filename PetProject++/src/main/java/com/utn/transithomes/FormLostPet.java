package com.utn.transithomes;

import java.util.List;

public class FormLostPet {

    private String especie;
    private String tamanio;
    private Ubication ubicacion;
    private List<String> caracteristicas;
    private Ubication lugarEncontrado;
    private List<String> caracteristicasDeLaPublicacionDelHogar;

    public FormLostPet(String especie, String tamanio, Ubication lugarEncontrado, List<String> caracteristicasDeLaPublicacionDelHogar) {
        this.especie = especie;
        this.tamanio = tamanio;
        this.lugarEncontrado = lugarEncontrado;
        this.caracteristicasDeLaPublicacionDelHogar = caracteristicasDeLaPublicacionDelHogar;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Ubication getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubication ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Ubication getLugarEncontrado() {
        return lugarEncontrado;
    }

    public void setLugarEncontrado(Ubication lugarEncontrado) {
        this.lugarEncontrado = lugarEncontrado;
    }

    public List<String> getCaracteristicasDeLaPublicacionDelHogar() {
        return caracteristicasDeLaPublicacionDelHogar;
    }

    public void setCaracteristicasDeLaPublicacionDelHogar(List<String> caracteristicasDeLaPublicacionDelHogar) {
        this.caracteristicasDeLaPublicacionDelHogar = caracteristicasDeLaPublicacionDelHogar;
    }
}
