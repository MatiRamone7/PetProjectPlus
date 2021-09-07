package com.utn.models.forms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.controllers.APIRestController;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.transithomes.*;
import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="formularioMascotaPerdida")
public class FormularioMascotaPerdida extends PersonaFormulario {

    /*
    Datos de Mascota
    */

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "direccionID", insertable = false, updatable = false)
    private Direccion lugarEncuentroMascota;

    @Transient
    private List<String> caracteristicasDeLaPublicacionDelHogar;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formularioMascotaPerdidaId")
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formularioMascotaPerdidaId")
    private Set<CaracteristicaPet> caracteristicas = new HashSet<>();


  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formularioMascotaPerdidaId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Mascota mascota;*/ /* por qué form mascota perdida tiene una mascota? si el q la encuentra no sabe q es´ta registrada?*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "estadoFormularioMascotaPerdidaId")
    private List<EstadoFormulario> estado;

    @Enumerated(EnumType.STRING)
    private Mascota.Especie especie;

    @Enumerated(EnumType.STRING)
    private Mascota.Sexo sexo;

    @Column
    private String hogar;

    public List<Hogar> mostrarHogares(){
        HogarDeTransito hogarDeTransito = new HogarDeTransito();
        return hogarDeTransito.hogaresTransito().stream().filter(hogar -> hogar.cumpleRequisitosDelHogar(this)).collect(Collectors.toList());//TODO: Mostrarlos en el html
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

    public Set<CaracteristicaPet> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<CaracteristicaPet> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getTamanio() {
        CaracteristicaPet caracteristica = caracteristicas.stream().
                filter(caract ->
                        caract.getTipoCaracteristica().getDescripcion() == "Tamanio"
                ).
                findFirst().orElse(null);
        if(caracteristica == null){
            return "";
        }
        return caracteristica.getvalor();
    }


 /*   public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }*/

    public List<EstadoFormulario> getEstado() {
        return estado;
    }

    public void setEstado(List<EstadoFormulario> estado) {
        this.estado = estado;
    }

    public Mascota.Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Mascota.Especie especie) {
        this.especie = especie;
    }

    public Mascota.Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Mascota.Sexo sexo) {
        this.sexo = sexo;
    }

    public String getHogar() {
        return hogar;
    }

    public void setHogar(String hogar) {
        this.hogar = hogar;
    }


    public Ubication getLugarEncontrado(){
        //TODO: Ver la API para obtener coordenadas

        Ubication ejemplo = APIRestController.getCoordenadasDeEstaDireccion(this.getDireccion());


        return ejemplo;
    }
}
