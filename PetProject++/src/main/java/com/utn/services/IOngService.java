package com.utn.services;

import com.utn.models.ongs.Organizacion;

import java.io.IOException;

public interface IOngService {
    public Organizacion Create (Organizacion ong) throws IOException;

}
