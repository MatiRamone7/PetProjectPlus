package com.utn.models;

import java.time.LocalDate;

public class EstadoFormulario {
    private Estado estado;

    private LocalDate fechaHora;

    private IUserLog user;

    public String logEstado(){
        //TODO
        return estado.getNombre();
    }
}
