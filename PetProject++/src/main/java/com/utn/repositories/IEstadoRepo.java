package com.utn.repositories;

import com.utn.models.forms.Estado;

public interface IEstadoRepo {
    public Iterable<Estado> GetEstados();

    public Estado GetEstadoById(Integer id);

    public Estado CreateEstado(Estado c);

    public Estado UpdateEstado(Estado c, Integer id);

    public void DeleteEstado(Integer id);

}
