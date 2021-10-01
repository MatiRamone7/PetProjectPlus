package com.utn.services;

import com.utn.models.mascotas.Caracteristica;

public interface ICaracteristicaService {
    public Iterable<Caracteristica> GetCaracteristicas();

    public Caracteristica GetCaracteristicaById(Integer id);

    public Caracteristica CreateCaracteristica(Caracteristica c);

    public Caracteristica UpdateCaracteristica(Caracteristica c, Integer id);

    public void DeleteCaracteristica(Integer id);
}
