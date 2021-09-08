package com.utn.models.forms;

import javax.persistence.*;
@Entity
@Table(name="direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "departamento/municipio/comuna")
    private String departamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudadId", referencedColumnName = "id")
    private Ciudad ciudad;

    @Column
    private String calle;

    @Column
    private int numero;

    @Column
    private String codigoPostal;

    @Transient
    private double latitud;

    @Transient
    private double longitud;

    public Direccion(Integer id, String departamento, Ciudad ciudad, String calle, int numero, String codigoPostal, double latitud, double longitud) {
        this.id = id;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Direccion(){}

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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
