package com.utn.repositories;

import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;

public interface IOngRepo {

    public Iterable<Organizacion> GetOngs();

    public Organizacion GetOngById(Integer id);

    public Organizacion CreateOng(Organizacion ong);

    public Organizacion UpdateOng(Organizacion ong, Integer id);

    public Organizacion AgregarPreguntaOng(String pregunta, Integer id);

    public Organizacion QuitarPreguntaOng(String pregunta, Integer id);

    public void DeleteOng(Integer id);

}
