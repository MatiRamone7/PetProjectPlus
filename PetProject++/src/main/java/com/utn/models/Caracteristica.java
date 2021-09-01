package com.utn.models;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="caracteristica")
public class Caracteristica implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;
}