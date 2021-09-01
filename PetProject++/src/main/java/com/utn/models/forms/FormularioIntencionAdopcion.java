package com.utn.models.forms;

import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.users.Usuario;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormularioIntencionAdopcion {

    private List<EstadoFormulario> estados;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    private Set<CaracteristicaPet> preferencias = new HashSet<>();

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private Usuario solicitante;

    public void actualizarFormulario(EstadoFormulario estado){}
}
