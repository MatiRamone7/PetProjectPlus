package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.Componentes.*;
import com.utn.transithomes.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FormularioMascotaPerdida extends PersonaFormulario implements Serializable {

    /*
    Datos de Rescatista
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechaDeNacimiento")
    private Date fechaDeNacimiento;

    @Column(name = "tipoDocumento")
    private String tipoDocumento;

    @Column(name = "nroDocumento")
    private int nroDocumento;

    @Column(name = "direccion")
    private Direccion direccion;

    private ContactoUnico contactoUnico;

    /*
    Datos de Mascota
    */
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "patronDistintivo")
    private String patronDistintivo;

    @Column(name = "lugarEncontrado")
    private Direccion lugarEncontrado;

    private List<String> caracteristicasDeLaPublicacionDelHogar;

    private List<Foto> fotos;

    private String tamanio;

    /*
    Datos de FormMascotaPerdida
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Organizacion organizacion;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "caracteristicaXaviso",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId") }
    )
    private Set<CaracteristicaPet> caracteristicSet = new HashSet<>();

    private int idMascota;

    private List<EstadoFormulario> estado;

    private Especie especie;

    private Hogar hogar;


    public List<EstadoFormulario> getEstado() {
        return estado;
    }

    public Especie getEspecie() {
        return especie;
    }

    public String getTamanio() {
        return tamanio;
    }

    public List<String> getCaracteristicasDeLaPublicacionDelHogar() {
        return caracteristicasDeLaPublicacionDelHogar;
    }

    public void asignarHogar(){
        HogarDeTransito hogarDeTransito = new HogarDeTransito();
        this.hogar = hogarDeTransito.hogaresTransito().stream().filter(hogar -> hogar.cumpleRequisitosDelHogar(this)).collect(Collectors.toList()).get(0);
    }
}
