package com.utn.repositories;

import com.utn.models.users.Comodidades.*;

public interface IComodidadesRepo{
    /*
        Comodidad
    */

    public Iterable<RadioDeCercania> GetRadioDeCercania();

    public RadioDeCercania GetRadioDeCercaniaById(Integer id);

    public RadioDeCercania CreateRadioDeCercania(RadioDeCercania c);

    public RadioDeCercania UpdateRadioDeCercania(RadioDeCercania c, Integer id);

    public void DeleteRadioDeCercania(Integer id);


    public Iterable<TienePatio> GetTienePatio();

    public TienePatio GetTienePatioById(Integer id);

    public TienePatio CreateTienePatio(TienePatio c);

    public TienePatio UpdateTienePatio(TienePatio c, Integer id);

    public void DeleteTienePatio(Integer id);

}
