package com.utn.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rol")
public class Rol implements Serializable {
    public Rol() {}

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

}