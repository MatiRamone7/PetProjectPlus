package com.utn.models.ongs;

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

    public Integer getId() {
        return id;
    }

    public int getNivelCalidad() {
        return nivelCalidad;
    }

    public void setNivelCalidad(int nivelCalidad) {
        this.nivelCalidad = nivelCalidad;
    }

    public int getSizeFoto() {
        return sizeFoto;
    }

    public void setSizeFoto(int sizeFoto) {
        this.sizeFoto = sizeFoto;
    }
}
