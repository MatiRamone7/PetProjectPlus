package com.utn.services;

import com.utn.models.mascotas.Caracteristica;

public interface ICaracteristicaService {
    public Iterable<Caracteristica> GetCaracteristicas();

    public Caracteristica GetCaracteristicaById(Integer id);

    public Caracteristica CreateCaracteristica(Caracteristica pet);

    public Caracteristica UpdateCaracteristica(Caracteristica pet, Integer id);

    public void DeleteCaracteristica(Integer id);
}
