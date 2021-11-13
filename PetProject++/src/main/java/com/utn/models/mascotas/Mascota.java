package com.utn.models.mascotas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utn.models.forms.Foto;
import com.utn.models.ongs.Organizacion;
import com.utn.models.users.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apodo")
    private String apodo;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Especie especie;

    @Column(name = "fecha_de_nacimiento", columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "mascota_id")
    private List<Foto> fotos;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "qr_id")
    private Foto qr;

    @Column(name = "descripcion_fisica")
    private String descripcionFisica;

    @ManyToOne
    @JoinColumn(name = "duenio_id")
    @JsonBackReference
    private Usuario duenio;

    @ManyToOne()
    @JoinColumn(name = "organizacion_id")
    @JsonBackReference
    private Organizacion ong;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "mascota_id")
    private Set<CaracteristicaPet> caracteristicSet = new HashSet<>();

    public Mascota(String nombre, String apodo, Sexo sexo, Especie especie, LocalDate fechaDeNacimiento,
            String descripcionFisica, Usuario usuarioId,
            Set<CaracteristicaPet> caracteristicSet) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.sexo = sexo;
        this.especie = especie;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.descripcionFisica = descripcionFisica;
        this.duenio = usuarioId;
        this.caracteristicSet = caracteristicSet;
    }
    public Mascota(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFoto(List<Foto> list) {
         list.stream().forEach((unaFoto)-> {fotos.add(unaFoto);});
    }

    public Foto getQr() {
        return qr;
    }

    public void setQr(Foto qr) {
        this.qr = qr;
    }

    public boolean tieneQr() {
        return (qr != null) ? true : false;
    }

    public String getDescripcionFisica() {
        return descripcionFisica;
    }

    public void setDescripcionFisica(String descripcionFisica) {
        this.descripcionFisica = descripcionFisica;
    }

    public Usuario getDuenio() {
        return duenio;
    }
    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }

    public Set<CaracteristicaPet> getCaracteristicSet() {
        return caracteristicSet;
    }

    public void setCaracteristicSet(Set<CaracteristicaPet> caracteristicSet) {
        this.caracteristicSet = caracteristicSet;
    }

    public enum Especie {
        PERRO,
        GATO
    }

    public enum Sexo {
        MACHO,
        HEMBRA,
    }
}
