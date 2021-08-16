package com.utn.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ong")
public class Ong implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estandarizacionDeImagen")
    private String estandarizacionDeImagen;

    @Column(name = "imagen")
    private byte[] imagen;

    private String[] preguntas;

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

    public String getEstandarizacionDeImagen() {
        return estandarizacionDeImagen;
    }

    public void setEstandarizacionDeImagen(String estandarizacionDeImagen) {
        this.estandarizacionDeImagen = estandarizacionDeImagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
