package com.utn.services;

import com.utn.models.Organizacion;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOngService {
    public Organizacion Create (Organizacion ong) throws IOException;

}
