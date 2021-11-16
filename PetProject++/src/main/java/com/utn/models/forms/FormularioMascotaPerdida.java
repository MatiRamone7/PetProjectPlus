package com.utn.models.forms;

import com.utn.controllers.APIRestController;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.transithomes.*;
import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="formulario_mascota_perdida")
public class FormularioMascotaPerdida extends PersonaFormulario {

    //DATOS MASCOTA

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "lugar_encuentro_mascota_id", insertable = false, updatable = false)
    private Direccion lugarEncuentroMascota;

    @Transient
    private List<String> caracteristicasDeLaPublicacionDelHogar;

    @Transient
    private Double distanciaMaximaEnKM;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_mascota_perdida_id")
    private List<Foto> fotos;

    //DATOS FORMULARIO

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Organizacion organizacion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "formulario_mascota_perdida_id")
    private Set<CaracteristicaPet> caracteristicas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_mascota_perdida_id")
    private List<EstadoFormulario> estado;

    @Enumerated(EnumType.STRING)
    private Mascota.Especie especie;

    @Enumerated(EnumType.STRING)
    private Mascota.Sexo sexo;

    @Column
    private String hogar;

    public List<Hogar> mostrarHogares(){
        HogarDeTransito hogarDeTransito = new HogarDeTransito();
        return hogarDeTransito.hogaresTransito().stream().filter(hogar -> hogar.cumpleRequisitosDelHogar(this)).collect(Collectors.toList());
    }

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
                        caract.getTipoCaracteristica().getDescripcion() == "Tamaño"
                ).
                findFirst().orElse(null);
        if(caracteristica == null){
            return "";
        }
        return caracteristica.getValor();
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

    public Double getDistanciaMaximaEnKM() {
        return distanciaMaximaEnKM;
    }

    public void setDistanciaMaximaEnKM(Double distanciaMaximaEnKM) {
        this.distanciaMaximaEnKM = distanciaMaximaEnKM;
    }


    public Ubication getLugarEncontrado(){
        Ubication ejemplo = APIRestController.getCoordenadasDeEstaDireccion(this.getDireccion());
        return ejemplo;
    }
}
