package com.utn.models.mascotas;


import javax.persistence.*;
@Entity
@Table(name="caracteristicas_mascota")
public class CaracteristicaPet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "caracteristica_pet_id", referencedColumnName = "id")
    public Caracteristica tipoCaracteristica;

    @Column(name = "valor")
    public String valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Caracteristica getTipoCaracteristica() {
        return tipoCaracteristica;
    }

    public void setTipoCaracteristica(Caracteristica c) {
        this.tipoCaracteristica = c;
    }
}