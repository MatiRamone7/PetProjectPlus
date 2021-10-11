package com.utn.models.mascotas;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="caracteristica")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "caracteristica", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CaracteristicaFiltrable> opciones;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CaracteristicaFiltrable> getOpciones() {
        return opciones;
    }
    public void setOpciones(List<CaracteristicaFiltrable> opciones) {
        this.opciones = opciones;
    }
}