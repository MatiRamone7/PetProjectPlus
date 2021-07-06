package com.utn.models.DarEnAdopcion;

import com.utn.models.Pet;
import com.utn.models.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="FormularioDarEnAdopcion")
public class FormGiveAdoption {
    public FormGiveAdoption(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private User userID;

    //Datos sobre la mascota
    @Id
    @JoinColumn(name = "petID")
    @OneToOne(cascade = { CascadeType.ALL })
    private Pet petID;

    //TODO: esto creo que tendría una relacion con otra tabla la cual contenga las caracteristicas especiales que nos da la ong, sería una relacion de muchos a muchos
    @ElementCollection
    private List<String> caracteristicasEspecialesPorONG;




    public FormGiveAdoption(User userID, Pet petID, List<String> caracteristicasEspecialesPorONG) {
        this.userID = userID;
        this.petID = petID;
        this.caracteristicasEspecialesPorONG = caracteristicasEspecialesPorONG;
    }

    public void guardarFormularioEnBD(){
        //TODO: preguntar como pasar todos los datos del formulario al controller para manipularlo
    }

}
