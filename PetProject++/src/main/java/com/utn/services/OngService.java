package com.utn.services;


import com.utn.models.Ong;
import com.utn.repositories.IOngRepo;
import com.utn.repositories.OngRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    public Ong Create(Ong ong) throws IOException {
        /*
        byte[] imagen = ong.getImagen();

        FileInputStream fileInputStream = new FileInputStream(String.valueOf(imagen));

        fileInputStream.read(imagen);
        fileInputStream.close();

        ong.setImagen(imagen);
        */

        Ong ongADevolver = ongRepo.CreateOng(ong);
        return ongADevolver;
    }
}