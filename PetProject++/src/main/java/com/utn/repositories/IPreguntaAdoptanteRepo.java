package com.utn.repositories;

import com.utn.models.ongs.PreguntaAdoptante;

public interface IPreguntaAdoptanteRepo {
    public Iterable<PreguntaAdoptante> GetPreguntasAdoptante();

    public PreguntaAdoptante GetPreguntaAdoptanteById(Integer id);

    public PreguntaAdoptante CreatePreguntaAdoptante(PreguntaAdoptante c);

    public PreguntaAdoptante UpdatePreguntaAdoptante(PreguntaAdoptante c, Integer id);

    public void DeletePreguntaAdoptante(Integer id);
}
