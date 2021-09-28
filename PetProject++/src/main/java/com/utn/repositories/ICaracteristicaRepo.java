package com.utn.repositories;

import com.utn.models.mascotas.Caracteristica;

public interface ICaracteristicaRepo {
    /*
        Form Mascota Perdida
    */

    public Iterable<Caracteristica> GetCaracteristica();

    public Caracteristica GetCaracteristicaById(Integer id);

    public Caracteristica CreateCaracteristica(Caracteristica form);

    public Caracteristica UpdateCaracteristica(Caracteristica form, Integer id);

    public void DeleteCaracteristica(Integer id);

}
