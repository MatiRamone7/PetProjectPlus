package com.utn.models.ongs;

import javax.persistence.*;
@Entity
@Table(name="caracteristicasFoto")
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
}
