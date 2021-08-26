package com.utn.models.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "Permiso")
public class Permiso implements Serializable {

    @Column(name = "nombreTecnico")
    private String nombreTecnico;

    @Column(name = "descripcion")
    private String descripcion;

    public Permiso(String nombreTecnico, String descripcion) {
        this.nombreTecnico = nombreTecnico;
        this.descripcion = descripcion;
    }

    //'getter and setter'
    public String getNombreTecnico() {
        return nombreTecnico;
    }
    public void setNombreTecnico(String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}