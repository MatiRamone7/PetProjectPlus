package com.utn.models.forms;

import javax.persistence.*;
@Entity
@Table(name="fotos")
public class Foto {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Lob
    @Column(name = "imagen", columnDefinition="VARBINARY(MAX)")
    public byte[] imagenByteArray;

    @Column(name = "descripcion")
    public String descripcion;

    public Foto(byte[] imagenByteArray, String descripcion) {
        this.imagenByteArray = imagenByteArray;
        this.descripcion = descripcion;
    }

    public Foto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagenByteArray() {
        return imagenByteArray;
    }

    public void setImagenByteArray(byte[] imagenByteArray) {
        this.imagenByteArray = imagenByteArray;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void describir(String ndescripcion){
        descripcion = ndescripcion;
    }

    public void imagenBufferedImage(byte[] nImagenByteArray){
        imagenByteArray = nImagenByteArray;
    }

    public String descripcion(){
       return descripcion;
    }
    
    public byte[] getImagenBI(){
         return imagenByteArray;
     }

}

