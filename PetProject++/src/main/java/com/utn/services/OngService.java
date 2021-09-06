package com.utn.services;


import com.utn.models.ongs.Organizacion;
import com.utn.repositories.IOngRepo;
import com.utn.repositories.OngRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de ongs.
 *
 * @author Grupo 14
 * @see Organizacion
 * @see OngRepo
 */
@Service
public class OngService implements IOngService{
    @Autowired
    IOngRepo ongRepo;

    /**
     * Crea una nueva ong.
     *
     * @param ong ong a crear
     * @return nuevo ong
     */
    public Organizacion Create(Organizacion ong){
        Organizacion ongADevolver = ongRepo.CreateOng(ong);
        return ongADevolver;
    }

    /**
     * Actualiza ong existente.
     *
     * @param ong ong a actualizar
     * @return ong actualizado
     */
    public Organizacion Update(Organizacion ong, Integer id) {
        return ongRepo.UpdateOng(ong, id);
    }

    /**
     * Actualiza preguntas de ong existente.
     *
     * @param pregunta a actualizar, id de la ong
     * @return ong actualizado
     */
    public Organizacion AgregarPregunta(String pregunta, Integer id) {
        return ongRepo.AgregarPregunta(pregunta, id);
    };

    /**
     * Actualiza preguntas de ong existente.
     *
     * @param pregunta a actualizar, id de la ong
     * @return ong actualizado
     */
    public Organizacion QuitarPregunta(String pregunta, Integer id) {
        return ongRepo.QuitarPregunta(pregunta, id);
    };
}
