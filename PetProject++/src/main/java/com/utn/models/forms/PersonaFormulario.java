package com.utn.models.forms;

import com.utn.models.users.ContactoUnico;
import com.utn.models.users.TipoDocumento;

import java.time.LocalDate;

public abstract class PersonaFormulario implements IUserLog {

    private String apellido;

    private ContactoUnico contacto;

    private Direccion direccion;

    private LocalDate fechaNacimiento;

    private String nombre;

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
