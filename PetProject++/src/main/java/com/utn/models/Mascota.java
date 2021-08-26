package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.utn.models.Componentes.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="mascota")
public class Mascota implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fotos")
    private List<Foto> fotos;

    @Column(name = "qr")
    private String qr;

    @Column(name = "descripcion")
    private String descripcionFisica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User usuarioId;

   /*@OneToMany
    @JoinTable(name = "caracteristicaxmascota", joinColumns = @JoinColumn(name="mascotaId"),
    inverseJoinColumns = @JoinColumn(name="caracteristicaId"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ElementCollection*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "caracteristica_por_mascota_id", referencedColumnName = "id")
    @NotNull
    private Set<CaracteristicaPet> caracteristicSet = new HashSet<>();

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

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public boolean tieneQr() {
        return (qr != null) ? true : false;
    }

    public User getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(User usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<CaracteristicaPet> getCaracteristicSet() {
        return caracteristicSet;
    }

    public void setCaracteristicSet(Set<CaracteristicaPet> caracteristicSet) {
        this.caracteristicSet = caracteristicSet;
    }
}
