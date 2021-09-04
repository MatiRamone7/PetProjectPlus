package com.utn.models.users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comodidad")
public class Comodidad implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;


    public Boolean cumpleComodidad(Usuario usuario){
        return true; //TODO :D
    }
}
