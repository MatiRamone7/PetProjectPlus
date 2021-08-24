package com.utn.models.Componentes;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Entity
public class Foto {
    public byte[] imagenByteArray;
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

