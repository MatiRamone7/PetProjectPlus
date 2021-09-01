package com.utn.models.Componentes;


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
    @JoinColumn(name = "caracteristica_id", referencedColumnName = "id")
    public Caracteristica tipoCaracteristica;

    @Column(name = "valor")
    public String valor;

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