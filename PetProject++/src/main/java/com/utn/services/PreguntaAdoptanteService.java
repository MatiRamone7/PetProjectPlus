package com.utn.services;

import com.utn.models.ongs.PreguntaAdoptante;
import com.utn.repositories.IPreguntaAdoptanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de PreguntaAdoptante.
 *
 * @author Grupo 14
 * @see PreguntaAdoptante
 * @see PreguntaAdoptanteRepo
 */
@Service
public class PreguntaAdoptanteService implements IPreguntaAdoptanteService{
    @Autowired
    IPreguntaAdoptanteRepo PreguntaAdoptanteRepo;

    /**
     * Retorna la lista de preguntaAdoptante.
     *
     * @return lista de preguntaAdoptante
     */
    @Override
    public Iterable<PreguntaAdoptante> GetPreguntasAdoptante() {
        return PreguntaAdoptanteRepo.GetPreguntasAdoptante();
    }

    /**
     * Busca una preguntaAdoptante por Id.
     *
     * @param id preguntaAdoptante de user a buscar
     * @return preguntaAdoptante existente
     */
    @Override
    public PreguntaAdoptante GetPreguntaAdoptanteById(Integer id) {
        return PreguntaAdoptanteRepo.GetPreguntaAdoptanteById(id);
    }

    /**
     * Crea un nuevo preguntaAdoptante.
     *
     * @param PreguntaAdoptante preguntaAdoptante a crear
     * @return nuevo preguntaAdoptante
     */
    public PreguntaAdoptante CreatePreguntaAdoptante(PreguntaAdoptante c) {
        return PreguntaAdoptanteRepo.CreatePreguntaAdoptante(c);
    }

    /**
     * Actualiza preguntaAdoptante existente.
     *
     * @param PreguntaAdoptante preguntaAdoptante a actualizar
     * @return preguntaAdoptante actualizado
     */
    public PreguntaAdoptante UpdatePreguntaAdoptante(PreguntaAdoptante c, Integer id) {
        return PreguntaAdoptanteRepo.UpdatePreguntaAdoptante(c, id);
    }

    /**
     * Borra preguntaAdoptante existente.
     *
     * @param id id de preguntaAdoptante a eliminar
     */
    public void DeletePreguntaAdoptante(Integer id) {
        PreguntaAdoptanteRepo.DeletePreguntaAdoptante(id);
    }

}