package com.utn.models.Componentes;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CaracteristicaPet{
    public Caracteristica tipoCaracteristica;

    @Column(name = "VALOR")
    public String valor;

    @Column(name = "ID_MASCOTA")
    public Integer idMascota;

    public Integer getId() {
        return idMascota;
    }

    public void setId(Integer id) {
        this.idMascota = id;
    }

    public String getvalor() {
        return valor;
    }

    public void setvalor(String valor) {
        this.valor = valor;
    }

    public Caracteristica getTipoCaracteristica() {
        return tipoCaracteristica;
    }

    public void setTipoCaracteristica(Caracteristica c) {
        this.tipoCaracteristica = c;
    }
}