package com.utn.services;

import com.utn.models.forms.Estado;

public interface IEstadoService {
    public Iterable<Estado> GetEstados();

    public Estado GetEstadoById(Integer id);

    public Estado CreateEstado(Estado Estado);

    public Estado UpdateEstado(Estado Estado, Integer id);

    public void DeleteEstado(Integer id);
}
