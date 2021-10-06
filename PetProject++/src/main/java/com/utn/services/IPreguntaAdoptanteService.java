package com.utn.services;

import com.utn.models.ongs.PreguntaAdoptante;

public interface IPreguntaAdoptanteService {
    public Iterable<PreguntaAdoptante> GetPreguntasAdoptante();

    public PreguntaAdoptante GetPreguntaAdoptanteById(Integer id);

    public PreguntaAdoptante CreatePreguntaAdoptante(PreguntaAdoptante c);

    public PreguntaAdoptante UpdatePreguntaAdoptante(PreguntaAdoptante c, Integer id);

    public void DeletePreguntaAdoptante(Integer id);
}
