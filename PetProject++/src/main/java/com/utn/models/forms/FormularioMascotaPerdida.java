package com.utn.models.forms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.transithomes.*;
import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

public class FormularioMascotaPerdida extends PersonaFormulario {

    /*
    Datos de Mascota
    */

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "lugarEncuentroMascota")
    private Direccion lugarEncuentroMascota;

    @Transient
    private List<String> caracteristicasDeLaPublicacionDelHogar;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fotoId", referencedColumnName = "id")
    private List<Foto> fotos;

    /*
    Datos de FormMascotaPerdida
    */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Organizacion organizacion;

    /*
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "caracteristicaXaviso",
            joinColumns = {@JoinColumn(name = "idAviso")},
            inverseJoinColumns = {@JoinColumn(name = "caracteristicaId")}
    )
    private Set<CaracteristicaPet> caracteristicSet;

    */

    /*
    @Transient
    private CaracteristicaPet tamanio = caracteristicSet.stream()
                                        .filter(caracteristica -> caracteristica.getTipoCaracteristica().getdescripcion().equals("Tamaño"))
                                        .findFirst()
                                        .orElse(null);
    */

    @Column(name = "tamanio")
    private String tamanio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mascotaId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Mascota mascota;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "estadoFormularioId", referencedColumnName = "id")
    private List<EstadoFormulario> estado;

    @Enumerated(EnumType.STRING)
    private Mascota.Especie especie;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hogarId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Hogar hogar;

    public void mostrarHogares(){
        HogarDeTransito hogarDeTransito = new HogarDeTransito();
        hogarDeTransito.hogaresTransito().stream().filter(hogar -> hogar.cumpleRequisitosDelHogar(this)).collect(Collectors.toList());//TODO: Mostrarlos en el html
    }

    /* TODO DANI
    public Ubication getLugarEncontrado() {
        // TODO
        return null;
    }
    */

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Direccion getLugarEncuentroMascota() {
        return lugarEncuentroMascota;
    }

    public void setLugarEncuentroMascota(Direccion lugarEncuentroMascota) {
        this.lugarEncuentroMascota = lugarEncuentroMascota;
    }

    public List<String> getCaracteristicasDeLaPublicacionDelHogar() {
        return caracteristicasDeLaPublicacionDelHogar;
    }

    public void setCaracteristicasDeLaPublicacionDelHogar(List<String> caracteristicasDeLaPublicacionDelHogar) {
        this.caracteristicasDeLaPublicacionDelHogar = caracteristicasDeLaPublicacionDelHogar;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<EstadoFormulario> getEstado() {
        return estado;
    }

    public void setEstado(List<EstadoFormulario> estado) {
        this.estado = estado;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Hogar getHogar() {
        return hogar;
    }

    public void setHogar(Hogar hogar) {
        this.hogar = hogar;
    }
}
