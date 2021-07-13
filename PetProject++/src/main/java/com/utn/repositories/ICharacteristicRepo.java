package com.utn.repositories;

import com.utn.models.Characteristic;

public interface ICharacteristicRepo {
    public Iterable<Characteristic> GetAll();

    public Characteristic GetById(Integer id);

    public Characteristic Create (Characteristic characteristic);

    public Characteristic Update (Characteristic characteristic, Integer id);

    public void Delete (Integer id);
}
