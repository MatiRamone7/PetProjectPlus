package com.utn.services;

import com.utn.models.forms.Ciudad;
import com.utn.models.forms.Provincia;

public interface IGeoService {
        //CIUDAD

        public Ciudad GetCiudadById(Integer id);

        public Iterable<Ciudad> GetCiudades();

        public Ciudad CreateCiudad(Ciudad c);
    
        public Ciudad UpdateCiudad(Ciudad c, Integer id);
    
        public void DeleteCiudad(Integer id);
    
        //PROVINCIA
    
        public Provincia GetProvinciaById(Integer id);

        public Iterable<Provincia> GetProvincias();
    
        public Provincia CreateProvincia(Provincia p);
    
        public Provincia UpdateProvincia(Provincia p, Integer id);
    
        public void DeleteProvincia(Integer id);
    
}
