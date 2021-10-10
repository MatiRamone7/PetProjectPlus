package com.utn.models.mascotas;

import javax.persistence.*;

@Entity
@Table(name="opcionesCaracteristicas")
public class CaracteristicaFiltrable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "caracteristicaId", referencedColumnName = "id")
    public Caracteristica caracteristica;

    @Column(name = "valor")
    public String valor;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
}
