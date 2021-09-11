package com.utn.services;

import com.utn.models.ongs.Organizacion;

public interface IOngService {
    public Organizacion Create (Organizacion ong);

    public Organizacion GetOngById(Integer id);

    public Organizacion Update (Organizacion ong, Integer id);

    public Organizacion AgregarPreguntaOng(String pregunta, Integer id);

    public Organizacion QuitarPreguntaOng(String pregunta, Integer id);
}
