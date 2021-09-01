package com.utn.models.mascotas;

import javax.persistence.*;
@Entity
@Table(name="caracteristicas_de_mascota")
public class CaracteristicaPet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mascota", referencedColumnName = "id")
    public Integer idMascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caracteristica_id", referencedColumnName = "id")
    public Caracteristica tipoCaracteristica;

    @Column(name = "valor")
    public String valor;
}