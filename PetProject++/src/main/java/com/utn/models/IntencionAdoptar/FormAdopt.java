package com.utn.models.IntencionAdoptar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.utn.models.Characteristic;
import com.utn.models.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="FormularioAdoptar")
public class FormAdopt {
    public FormAdopt(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    //Datos sobre el usuario

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private User userID;

    //Datos sobre la mascota
    @ManyToMany
    @NotNull
    @JoinTable(name = "caracteristicaXformularioAdoptar",
            joinColumns = @JoinColumn(name="idAviso"),
            inverseJoinColumns = @JoinColumn(name="caracteristicaId"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Characteristic> caracteristicSet = new HashSet<>();

    //TODO: estas caracteristicas serían las siguientes con sus respectivos valores
/*
    private String especie;
    private String raza;
    private String sexo;
    private String colorPrincipal;
    private String colorSecundario;
    private Boolean esterilizado;
    private Boolean rabo;
    private Boolean discapacidad;
    private String tamanio;
*/

    public void guardarFormularioEnBD(){
        //TODO: preguntar como pasar todos los datos del formulario al controller para manipularlo
    }

}
