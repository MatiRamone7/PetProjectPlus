package com.utn.services;


import com.utn.models.Ong;
import com.utn.repositories.IOngRepo;
import com.utn.repositories.OngRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de ongs.
 *
 * @author Grupo 14
 * @see Ong
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
    public Ong Create(Ong ong)
    {
        return ongRepo.CreateOng(ong);
    }
}
