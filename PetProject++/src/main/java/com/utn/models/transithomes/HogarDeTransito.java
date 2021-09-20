package com.utn.models.transithomes;

import java.util.List;

public class HogarDeTransito {
    private AdapterRefugios adapter = AdapterApiRestHogaresDeTransito.getInstancia();

    public List<Hogar> hogaresTransito(){
        return adapter.obtenerHogaresTransito();
    }
}
