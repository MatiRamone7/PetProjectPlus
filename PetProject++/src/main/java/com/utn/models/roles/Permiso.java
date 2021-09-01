package com.utn.models.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "Permiso")
public class Permiso implements Serializable {

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nombreTecnico")
    private String nombreTecnico;
}