package com.utn.models.mascotas;


import javax.persistence.*;
@Entity
@Table(name="caracteristicasMascota")
public class CaracteristicaPet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "caracteristicaPetId")
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