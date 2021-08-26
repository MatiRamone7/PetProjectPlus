package com.utn.models;

import java.time.LocalDate;

import com.utn.models.Componentes.TipoDocumento;

public class FormularioMascotaEncontrada implements IUserLog{
    private LocalDate fechaHora;
    private FormularioMascotaPerdida formularioMascotaPerdida;
    private int id;
    private User usuario;

    public String apellido(){
        return usuario.getApellido();
    }

    public String nombre(){
        return usuario.getNombre();
    }

    public int nroDocumento(){
        return usuario.getNumeroDocumento();
    }

    public TipoDocumento tipoDocumento(){
        return usuario.getTipoDocumento();
    }

    public String usuario(){
        return "Id: " + usuario.getId().toString() + " - Nombre: " + usuario.getNombre() + " " + usuario.getApellido();
    }

    public void contactar(){
    }
}
