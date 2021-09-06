package com.utn.services;

import com.utn.models.ongs.Organizacion;

public interface IOngService {
    public Organizacion Create (Organizacion ong);

    public Organizacion Update (Organizacion ong, Integer id);
}
