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
    @Column(name = "imagen", columnDefinition="VARBINARY(8000)")
    public byte[] imagenByteArray;

    @Column(name = "descripcion")
    public String descripcion;

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

