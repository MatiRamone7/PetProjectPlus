package com.utn.services;

import com.utn.models.mascotas.Mascota;
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
     * Retorna la lista de ongs.
     *
     * @return lista de ongs
     */
    @Override
    public Iterable<Organizacion> GetOngs() {
        return ongRepo.GetOngs();
    }


    /**
     * Busca una pet por Id.
     *
     * @param id id de user a buscar
     * @return user existente
     */
    public Organizacion GetOngById(Integer id) {
        return ongRepo.GetOngById(id);
    }


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
    public Organizacion AgregarPreguntaOng(String pregunta, Integer id) {
        return ongRepo.AgregarPreguntaOng(pregunta, id);
    };

    /**
     * Actualiza preguntas de ong existente.
     *
     * @param pregunta a actualizar, id de la ong
     * @return ong actualizado
     */
    public Organizacion QuitarPreguntaOng(String pregunta, Integer id) {
        return ongRepo.QuitarPreguntaOng(pregunta, id);
    };

    /**
     * Borra ong existente.
     *
     * @param id id de pet a eliminar
     */
    public void DeleteOng(Integer id) {
        ongRepo.DeleteOng(id);
    }
}
