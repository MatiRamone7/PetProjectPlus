package com.utn.models;

import com.utn.models.Componentes.TipoDocumento;

public interface IUserLog {
    public String apellido();

    public String nombre();

    public int nroDocumento();

    public TipoDocumento tipoDocumento();

    public String usuario();
}
