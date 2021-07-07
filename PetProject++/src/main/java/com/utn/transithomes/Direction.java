package com.utn.transithomes;

import com.utn.transithomes.MascotaPerdida.FormLostPet;

import javax.persistence.FetchType;
import javax.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(fetch = FetchType.LAZY)
    private FormLostPet formularioMascotaPerdida;

    @Basic
    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "codigoPostal")
    private String codigoPostal;

    @Column(name = "barrio")
    private String barrio;

    @Column(name = "provincia")
    private String provincia;

    /*public Direction(String calle, int numero, String departamento, String codigoPostal, String barrio, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
        this.barrio = barrio;
        this.provincia = provincia;
    }*/

    public String getCalle() { return calle; }

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
