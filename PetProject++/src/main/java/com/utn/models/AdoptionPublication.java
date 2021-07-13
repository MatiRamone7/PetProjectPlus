package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="publicacionDeAdopcion")
public class AdoptionPublication {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToMany
    @NotNull
    @JoinTable(name = "caracteristicaxpublicacionAdopcion", joinColumns = @JoinColumn(name="publicacionId"),
            inverseJoinColumns = @JoinColumn(name="caracteristicaId"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Characteristic> caracteristicas;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "especie")
    private String especie;

    @Column(name = "fechaDeNacimiento")
    private String fechaDeNacimiento;

}

