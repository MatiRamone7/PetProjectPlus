package com.utn.models.forms;

import com.utn.models.users.TipoDocumento;

public interface IUserLog {
    public String apellido();

    public String nombre();

    public int nroDocumento();

    public TipoDocumento tipoDocumento();

    public String usuario();
}
