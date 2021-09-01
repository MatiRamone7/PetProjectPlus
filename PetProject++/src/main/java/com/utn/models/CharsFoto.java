package com.utn.models;

import javax.persistence.*;
@Entity
@Table(name="caracteristicas_foto")
public class CharsFoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nivel_calidad")
    public int nivelCalidad;

    @Column(name = "tamanio_foto")
    public int sizeFoto;

    public int getSizeFoto() {
        return sizeFoto;
    }

    public void setSizeFoto(int sizeFoto) {
        this.sizeFoto = sizeFoto;
    }

    public int getNivelCalidad() {
        return nivelCalidad;
    }

    public void setNivelCalidad(int NivelCalidad) {
        this.nivelCalidad = NivelCalidad;
    }
}
