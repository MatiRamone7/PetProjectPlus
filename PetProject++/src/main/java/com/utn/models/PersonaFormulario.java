package com.utn.models;

import java.time.LocalDate;
import java.util.Date;

import com.utn.models.Componentes.TipoDocumento;

public abstract class PersonaFormulario implements IUserLog{
    private String apellido;
    private String nombre;
    private ContactoUnico contacto;
    private Direccion direccion;
    private LocalDate fechaNacimiento;
    private int nroDocumento;
    private TipoDocumento tipoDocumento;

    public String apellido(){
        return apellido;
    }

    public String nombre(){
        return nombre;
    }

    public int nroDocumento(){
        return nroDocumento;
    }

    public TipoDocumento tipoDocumento(){
        return tipoDocumento;
    }

    public String usuario(){
        return "Ejemplo";
    }
}
