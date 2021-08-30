package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.Componentes.*;
import com.utn.transithomes.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FormularioMascotaPerdida extends PersonaFormulario implements Serializable {
    /*
    Datos de Mascota
    */
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "patronDistintivo")
    private String patronDistintivo;

    @Column(name = "lugarEncontrado")
    private Direccion lugarEncontrado;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "caracteristicaXaviso",
            joinColumns = {@JoinColumn(name = "idAviso")},
            inverseJoinColumns = {@JoinColumn(name = "caracteristicaId")}
    )
    private Set<CaracteristicaPet> caracteristicSet = new HashSet<>();

    @Transient
    private CaracteristicaPet tamanio = caracteristicSet.stream()
                                        .filter(caracteristica -> caracteristica.getTipoCaracteristica().getdescripcion().equals("Tamaño"))
                                        .findFirst()
                                        .orElse(null);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mascotaId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Mascota idMascota;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "estadoFormularioId", referencedColumnName = "id")
    private List<EstadoFormulario> estado;

    @Enumerated(EnumType.STRING)
    private Especie especie;

    @Transient
    private Hogar hogar;


    public List<EstadoFormulario> getEstado() {
        return estado;
    }

    public Especie getEspecie() {
        return especie;
    }

    public String getTamanio() {
        return tamanio.getvalor();
    }

    public List<String> getCaracteristicasDeLaPublicacionDelHogar() {
        return caracteristicasDeLaPublicacionDelHogar;
    }

    public void mostrarHogares(){
        HogarDeTransito hogarDeTransito = new HogarDeTransito();
        hogarDeTransito.hogaresTransito().stream().filter(hogar -> hogar.cumpleRequisitosDelHogar(this)).collect(Collectors.toList());//TODO: Mostrarlos en el html
    }

    public Ubication getLugarEncontrado() {
        // TODO
        return null;
    }
}
