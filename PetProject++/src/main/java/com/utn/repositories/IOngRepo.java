package com.utn.repositories;


import com.utn.models.ongs.Organizacion;
import com.utn.models.users.Usuario;

public interface IOngRepo {
    public Organizacion GetOngById(Integer id);

    public Organizacion CreateOng(Organizacion ong);

    public Organizacion UpdateOng(Organizacion ong, Integer id);

    public Organizacion AgregarPreguntaOng(String pregunta, Integer id);

    public Organizacion QuitarPreguntaOng(String pregunta, Integer id);
}
