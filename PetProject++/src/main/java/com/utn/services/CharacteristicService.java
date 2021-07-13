package com.utn.services;

import com.utn.models.Characteristic;
import com.utn.repositories.CharacteristicRepo;
import com.utn.repositories.ICharacteristicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de characteristic.
 *
 * @author Grupo 14
 * @see Characteristic
 * @see CharacteristicRepo
 */
@Service
public class CharacteristicService implements ICharacteristicService{

    @Autowired
    ICharacteristicRepo characteristicRepo;

    @Override
    public Iterable<Characteristic> GetAll() {
        return characteristicRepo.GetAll();
    }

    @Override
    public Characteristic GetById(Integer id) {
        return null;
    }

    @Override
    public Characteristic Create(Characteristic characteristic) {
        return null;
    }

    @Override
    public Characteristic Update(Characteristic characteristic, Integer id) {
        return null;
    }

    @Override
    public void Delete(Integer id) {

    }
}
