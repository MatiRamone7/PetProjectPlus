package com.utn.repositories;

import com.utn.models.forms.Ciudad;
import com.utn.models.forms.Provincia;

public interface IGeoRepo {
    //CIUDAD

    public Iterable<Ciudad> GetCiudades();

    public Ciudad GetCiudadById(Integer id);

    public Ciudad CreateCiudad(Ciudad c);

    public Ciudad UpdateCiudad(Ciudad c, Integer id);

    public void DeleteCiudad(Integer id);

    //PROVINCIA

    public Iterable<Provincia> GetProvincias();

    public Provincia GetProvinciaById(Integer id);

    public Provincia CreateProvincia(Provincia p);

    public Provincia UpdateProvincia(Provincia p, Integer id);

    public void DeleteProvincia(Integer id);

}
