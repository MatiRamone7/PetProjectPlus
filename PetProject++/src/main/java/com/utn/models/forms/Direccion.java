package com.utn.models.forms;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="mascota")
public class Direccion {

    private String calle;

    private Ciudad ciudad;

    private String codigoPostal;

    private Double latitud;

    private Double longitud;

    private int numero;

    public String direccionCompleta(){
        return null;
    }
}
