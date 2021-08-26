package com.utn.models;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="mascota")
public class Direccion {
    private String calle;
    private int numero;
    private String departamento;
    private String codigoPostal;
    private String barrio;
    private String provincia;

    public Direccion(String calle, int numero, String departamento, String codigoPostal, String barrio, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
        this.barrio = barrio;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
